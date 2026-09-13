import fs from "node:fs";
import path from "node:path";
import { fileURLToPath } from "node:url";

const scriptDirectory = path.dirname(fileURLToPath(import.meta.url));
const repositoryRoot = path.resolve(scriptDirectory, "..");
const generatedProblemsDirectory = path.join(repositoryRoot, "problems");
const generatedHomePage = path.join(repositoryRoot, "index.html");
const siteUrl = (process.env.SITE_URL ?? "https://suvraneel.github.io/LeetCode").replace(/\/$/, "");

const languageNames = {
  cpp: "C++",
  java: "Java",
  js: "JavaScript",
  py: "Python",
  ts: "TypeScript",
};

const highlightLanguages = {
  cpp: "cpp",
  java: "java",
  js: "javascript",
  py: "python",
  ts: "typescript",
};

const sourceExtensions = new Set(Object.keys(languageNames));

const escapeHtml = (value) =>
  value
    .replace(/&/g, "&amp;")
    .replace(/</g, "&lt;")
    .replace(/>/g, "&gt;")
    .replace(/\"/g, "&quot;")
    .replace(/'/g, "&#39;");

const titleFromSlug = (slug) => {
  const words = slug.split("-");
  const smallWords = new Set([
    "a", "an", "and", "as", "at", "by", "for", "from", "in", "into", "of", "on", "or", "the", "to", "with",
  ]);
  const acronyms = new Set(["api", "ascii", "bst", "cpu", "dfs", "dp", "gcd", "ii", "iii", "iv", "json", "lru", "nary", "sql", "tcp", "trie", "uf", "utf", "uuid", "xml"]);

  return words
    .map((word, index) => {
      const normalized = word.toLowerCase();
      if (/^\d+$/.test(word)) return word;
      if (normalized === "atoi") return "atoi";
      if (acronyms.has(normalized)) return normalized.toUpperCase();
      if (index !== 0 && index !== words.length - 1 && smallWords.has(normalized)) return normalized;
      return normalized[0].toUpperCase() + normalized.slice(1);
    })
    .join(" ");
};

const difficultyFromReadme = (directory) => {
  const readmePath = path.join(repositoryRoot, directory, "README.md");
  if (!fs.existsSync(readmePath)) return "—";

  const readme = fs.readFileSync(readmePath, "utf8");
  return readme.match(/<h[23]>\s*(Easy|Medium|Hard)\s*<\/h[23]>/i)?.[1] ?? "—";
};

const problemStatementFromReadme = (directory) => {
  const readmePath = path.join(repositoryRoot, directory, "README.md");
  if (!fs.existsSync(readmePath)) {
    return "<p>The local problem statement is unavailable. Please use the LeetCode link above.</p>";
  }
  return fs.readFileSync(readmePath, "utf8");
};

const notesFromDirectory = (directory) => {
  const notesPath = path.join(repositoryRoot, directory, "NOTES.md");
  return fs.existsSync(notesPath) ? fs.readFileSync(notesPath, "utf8").replace(/\u200B/g, "").trim() : "";
};

const solutionLabel = (fileName, directory, extension) => {
  const language = languageNames[extension];
  const stem = fileName.slice(0, -(extension.length + 1));
  const variant = stem.startsWith(directory) ? stem.slice(directory.length).replace(/^-/, "") : stem;
  return variant ? `${language} — ${variant.replaceAll("-", " ")}` : language;
};

const getProblems = () => {
  const candidates = fs
    .readdirSync(repositoryRoot, { withFileTypes: true })
    .filter((entry) => entry.isDirectory())
    .map((entry) => {
      const match = entry.name.match(/^(\d+)-(.+)$/);
      if (!match) return null;

      const [, number, slug] = match;
      const solutions = fs
        .readdirSync(path.join(repositoryRoot, entry.name), { withFileTypes: true })
        .filter((file) => file.isFile())
        .map((file) => ({
          fileName: file.name,
          extension: path.extname(file.name).slice(1).toLowerCase(),
        }))
        .filter((file) => sourceExtensions.has(file.extension))
        .sort((a, b) => a.extension.localeCompare(b.extension) || a.fileName.localeCompare(b.fileName));

      return {
        directory: entry.name,
        number: Number(number),
        slug,
        title: titleFromSlug(slug),
        difficulty: difficultyFromReadme(entry.name),
        solutions,
      };
    })
    .filter(Boolean);

  const problemsByNumber = new Map();
  for (const candidate of candidates) {
    const candidateSolutions = candidate.solutions.map((solution) => ({
      ...solution,
      directory: candidate.directory,
    }));
    const current = problemsByNumber.get(candidate.number);

    if (!current) {
      problemsByNumber.set(candidate.number, { ...candidate, solutions: candidateSolutions });
      continue;
    }

    current.solutions.push(...candidateSolutions);
    const paddedDirectory = String(candidate.number).padStart(4, "0");
    if (candidate.directory.startsWith(paddedDirectory)) {
      current.directory = candidate.directory;
      current.slug = candidate.slug;
      current.title = candidate.title;
      current.difficulty = candidate.difficulty;
    }
  }

  return [...problemsByNumber.values()]
    .map((problem) => {
      const solutions = problem.solutions.sort(
        (a, b) => a.extension.localeCompare(b.extension) || a.fileName.localeCompare(b.fileName),
      );
      const labels = solutions.map((solution) => solutionLabel(solution.fileName, solution.directory, solution.extension));
      const labelCounts = new Map(labels.map((label) => [label, labels.filter((item) => item === label).length]));
      const labelIndexes = new Map();

      return {
        ...problem,
        pageKey: String(problem.number),
        solutions: solutions.map((solution, index) => {
          const label = labels[index];
          const occurrence = (labelIndexes.get(label) ?? 0) + 1;
          labelIndexes.set(label, occurrence);
          return {
            ...solution,
            label: labelCounts.get(label) > 1 ? `${label} — alternative ${occurrence}` : label,
          };
        }),
      };
    })
    .sort((a, b) => a.number - b.number);
};

const problemPage = (problem) => {
  const statement = problemStatementFromReadme(problem.directory);
  const notes = notesFromDirectory(problem.directory);
  const solutionNavigation = problem.solutions
    .map(
      (solution, index) =>
        `<button type="button" class="solution-tab${index === 0 ? " active" : ""}" data-solution="solution-${index + 1}" aria-controls="solution-${index + 1}" aria-selected="${index === 0}">${escapeHtml(solution.label)}</button>`,
    )
    .join("");

  const solutionSections = problem.solutions
    .map((solution, index) => {
      const source = fs.readFileSync(path.join(repositoryRoot, solution.directory, solution.fileName), "utf8");
      return `<section id="solution-${index + 1}" class="solution-panel"${index === 0 ? "" : " hidden"}><div class="solution-heading"><h2>${escapeHtml(solution.label)}</h2><div><a href="../../${encodeURIComponent(solution.directory)}/${encodeURIComponent(solution.fileName)}">Source file</a><button type="button" class="copy-code">Copy code</button></div></div><pre><code class="language-${highlightLanguages[solution.extension]}">${escapeHtml(source)}</code></pre></section>`;
    })
    .join("\n");

  return `<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>${escapeHtml(`${problem.number}. ${problem.title}`)} · LeetCode Solutions</title>
  <link id="highlight-theme" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.11.1/styles/github.min.css">
  <style>
    :root { --bg:#fff; --surface:#f6f8fa; --text:#24292f; --muted:#57606a; --line:#d0d7de; --link:#0969da; } [data-theme="dark"] { --bg:#0d1117; --surface:#161b22; --text:#e6edf3; --muted:#8b949e; --line:#30363d; --link:#58a6ff; } body { max-width:980px; margin:0 auto; padding:2rem 1rem 4rem; background:var(--bg); color:var(--text); font:16px/1.55 system-ui,sans-serif; } a { color:var(--link); } header { border-bottom:1px solid var(--line); margin-bottom:2rem; padding-bottom:1rem; } .meta,nav,.solution-heading { display:flex; flex-wrap:wrap; gap:.65rem; align-items:center; justify-content:space-between; } .badge { background:var(--surface); border-radius:999px; padding:.15rem .65rem; } nav { justify-content:flex-start; } button,nav button { border:1px solid var(--line); background:var(--bg); color:var(--text); border-radius:6px; padding:.35rem .65rem; cursor:pointer; font:inherit; } nav button.active,button:hover { background:var(--surface); } section { margin-top:2.5rem; } #problem-statement { border-bottom:1px solid var(--line); padding-bottom:2rem; } #problem-statement img { max-width:100%; height:auto; } pre { border:1px solid var(--line); border-radius:6px; overflow:auto; padding:1rem; } code { font:13px/1.45 ui-monospace,SFMono-Regular,Menlo,monospace; } .solution-heading h2 { margin:0; } [hidden] { display:none; } #theme-toggle { float:right; }
  </style>
</head>
<body>
  <header>
    <button id="theme-toggle" type="button" aria-label="Toggle color theme">Theme</button><p><a href="../../">← All problems</a></p>
    <h1>${escapeHtml(`${problem.number}. ${problem.title}`)}</h1>
    <div class="meta"><span class="badge">${escapeHtml(problem.difficulty)}</span><a href="https://leetcode.com/problems/${encodeURIComponent(problem.slug)}/">Open on LeetCode</a><a href="#problem-statement">Problem statement</a></div>
  </header>
  <section id="problem-statement">
    <h2>Problem Statement</h2>
    ${statement}
  </section>
  ${notes ? `<section id="notes"><h2>Notes / Approach</h2>${notes}</section>` : ""}
  <nav aria-label="Solutions">${solutionNavigation}</nav>
  ${solutionSections || "<p>No supported solution files were found for this problem.</p>"}
  <script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.11.1/highlight.min.js"></script>
  <script>hljs.highlightAll();const root=document.documentElement,theme=document.getElementById('highlight-theme'),toggle=document.getElementById('theme-toggle');const setTheme=t=>{root.dataset.theme=t;theme.href='https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.11.1/styles/github'+(t==='dark'?'-dark':'')+'.min.css';localStorage.setItem('theme',t)};setTheme(localStorage.getItem('theme')||(matchMedia('(prefers-color-scheme: dark)').matches?'dark':'light'));toggle.onclick=()=>setTheme(root.dataset.theme==='dark'?'light':'dark');document.querySelectorAll('.solution-tab').forEach(tab=>tab.onclick=()=>{document.querySelectorAll('.solution-panel').forEach(panel=>panel.hidden=panel.id!==tab.dataset.solution);document.querySelectorAll('.solution-tab').forEach(item=>{item.classList.toggle('active',item===tab);item.setAttribute('aria-selected',item===tab)})});document.querySelectorAll('.copy-code').forEach(button=>button.onclick=async()=>{await navigator.clipboard.writeText(button.closest('.solution-panel').querySelector('code').innerText);button.textContent='Copied';setTimeout(()=>button.textContent='Copy code',1400)});</script>
</body>
</html>`;
};

const buildReadme = (problems) => {
  const rows = problems
    .map((problem) => {
      const links = problem.solutions.length
        ? problem.solutions
            .map(
              (solution, index) =>
                `[${solution.label}](${siteUrl}/problems/${problem.pageKey}/#solution-${index + 1})`,
            )
            .join("<br>")
        : "—";
      return `| [${problem.number}](https://leetcode.com/problems/${problem.slug}/) | [${problem.title}](${siteUrl}/problems/${problem.pageKey}/#problem-statement) | ${problem.difficulty} | ${links} |`;
    })
    .join("\n");

  return `# [![LeetCode](https://img.shields.io/badge/-LeetCode-da8200?style=for-the-badge&logo=LeetCode&logoColor=ffa116&labelColor=black)](https://leetcode.com/Suvraneel/)

<p><b>Documenting my LeetCode journey</b> one problem at a time.</p>

Each solution link opens a readable page with every submitted implementation and variant.

| # | Problem Statement | Difficulty | Solutions |
|---:|:---|:---|:---|
${rows}
`;
};

const homePage = (problems) => {
  const counts = Object.fromEntries(["Easy", "Medium", "Hard"].map((difficulty) => [difficulty, problems.filter((p) => p.difficulty === difficulty).length]));
  const languages = [...new Set(problems.flatMap((p) => p.solutions.map((s) => languageNames[s.extension])))].sort();
  const data = problems.map((p) => ({ n:p.number, t:p.title, d:p.difficulty, l:[...new Set(p.solutions.map((s) => languageNames[s.extension]))], notes:Boolean(notesFromDirectory(p.directory)), u:`${siteUrl}/problems/${p.pageKey}/#problem-statement` }));
  return `<!doctype html><html lang="en"><head><meta charset="utf-8"><meta name="viewport" content="width=device-width,initial-scale=1"><title>Suvraneel's LeetCode Archive</title><style>:root{--bg:#fff;--surface:#f6f8fa;--text:#24292f;--muted:#57606a;--line:#d0d7de;--link:#0969da}[data-theme=dark]{--bg:#0d1117;--surface:#161b22;--text:#e6edf3;--muted:#8b949e;--line:#30363d;--link:#58a6ff}*{box-sizing:border-box}body{margin:0;background:var(--bg);color:var(--text);font:16px/1.5 system-ui,sans-serif}main{max-width:1180px;margin:auto;padding:3rem 1rem 5rem}header{display:flex;justify-content:space-between;align-items:start;border-bottom:1px solid var(--line);padding-bottom:2rem}h1{font-size:clamp(2rem,6vw,4rem);letter-spacing:-.06em;margin:0}p{color:var(--muted)}button,input,select{font:inherit;border:1px solid var(--line);border-radius:7px;background:var(--bg);color:var(--text);padding:.6rem .75rem}button{cursor:pointer}.stats{display:grid;grid-template-columns:repeat(4,1fr);gap:1px;background:var(--line);border:1px solid var(--line);margin:2rem 0}.stat{background:var(--surface);padding:1rem}.stat b{font-size:1.65rem;display:block}.controls{display:grid;grid-template-columns:2fr 1fr 1fr;gap:.75rem;margin:1rem 0}.result{color:var(--muted);font-size:.9rem}.problem{display:grid;grid-template-columns:70px 1fr auto;gap:1rem;align-items:center;padding:1rem 0;border-bottom:1px solid var(--line)}.number{font:600 14px ui-monospace,monospace;color:var(--muted)}.title{color:var(--link);font-weight:650;text-decoration:none}.badges{display:flex;gap:.35rem;flex-wrap:wrap}.badge{border:1px solid var(--line);border-radius:99px;padding:.1rem .45rem;font-size:.78rem;color:var(--muted)}@media(max-width:650px){main{padding-top:1.5rem}.stats{grid-template-columns:repeat(2,1fr)}.controls{grid-template-columns:1fr}.problem{grid-template-columns:50px 1fr}.badges{grid-column:2}header{display:block}#theme{margin-top:1rem}}</style></head><body><main><header><div><p>PERSONAL ARCHIVE</p><h1>LeetCode<br>Solutions.</h1><p>${problems.length} problems, indexed from the repository.</p></div><button id="theme">Theme</button></header><section class="stats"><div class="stat"><b>${problems.length}</b>Solved</div><div class="stat"><b>${counts.Easy}</b>Easy</div><div class="stat"><b>${counts.Medium}</b>Medium</div><div class="stat"><b>${counts.Hard}</b>Hard</div></section><section><div class="controls"><input id="query" type="search" placeholder="Search title or problem number"><select id="difficulty"><option value="">All difficulties</option><option>Easy</option><option>Medium</option><option>Hard</option></select><select id="language"><option value="">All languages</option>${languages.map(l=>`<option>${l}</option>`).join("")}</select></div><p id="result" class="result"></p><div id="list"></div></section></main><script>const data=${JSON.stringify(data).replace(/</g,"\\u003c")},root=document.documentElement,theme=document.querySelector('#theme'),setTheme=t=>{root.dataset.theme=t;localStorage.setItem('theme',t)};setTheme(localStorage.getItem('theme')||(matchMedia('(prefers-color-scheme: dark)').matches?'dark':'light'));theme.onclick=()=>setTheme(root.dataset.theme==='dark'?'light':'dark');const q=document.querySelector('#query'),d=document.querySelector('#difficulty'),l=document.querySelector('#language'),list=document.querySelector('#list'),result=document.querySelector('#result');function render(){const term=q.value.toLowerCase(),items=data.filter(p=>(p.t+' '+p.n).toLowerCase().includes(term)&&(!d.value||p.d===d.value)&&(!l.value||p.l.includes(l.value)));result.textContent=items.length+' matching problems';list.innerHTML=items.map(p=>'<article class="problem"><span class="number">#'+p.n+'</span><a class="title" href="'+p.u+'">'+p.t+'</a><span class="badges"><span class="badge">'+p.d+'</span>'+p.l.map(x=>'<span class="badge">'+x+'</span>').join('')+(p.notes?'<span class="badge">Notes</span>':'')+'</span></article>').join('')}[q,d,l].forEach(el=>el.oninput=render);render()</script></body></html>`;
};

const build = () => {
  const problems = getProblems();
  fs.rmSync(generatedProblemsDirectory, { recursive: true, force: true });
  fs.mkdirSync(generatedProblemsDirectory, { recursive: true });

  for (const problem of problems) {
    const destination = path.join(generatedProblemsDirectory, problem.pageKey);
    fs.mkdirSync(destination, { recursive: true });
    fs.writeFileSync(path.join(destination, "index.html"), problemPage(problem));
  }

  fs.writeFileSync(path.join(repositoryRoot, "README.md"), buildReadme(problems));
  fs.writeFileSync(generatedHomePage, homePage(problems));
  console.log(`Generated ${problems.length} problem pages, dashboard, and solution catalog.`);
};

build();
