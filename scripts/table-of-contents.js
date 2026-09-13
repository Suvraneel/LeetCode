import fs from "node:fs";
import path from "node:path";
import { fileURLToPath } from "node:url";

const scriptDirectory = path.dirname(fileURLToPath(import.meta.url));
const repositoryRoot = path.resolve(scriptDirectory, "..");
const generatedProblemsDirectory = path.join(repositoryRoot, "problems");
const siteUrl = (process.env.SITE_URL ?? "https://suvraneel.github.io/LeetCode").replace(/\/$/, "");

const languageNames = {
  cpp: "C++",
  java: "Java",
  js: "JavaScript",
  py: "Python",
  ts: "TypeScript",
};

const sourceExtensions = new Set(Object.keys(languageNames));

const escapeHtml = (value) =>
  value
    .replace(/&/g, "&amp;")
    .replace(/</g, "&lt;")
    .replace(/>/g, "&gt;")
    .replace(/\"/g, "&quot;")
    .replace(/'/g, "&#39;");

const titleFromSlug = (slug) =>
  slug
    .split("-")
    .map((word) =>
      /^\d+$/.test(word) || word.length <= 3
        ? word.toUpperCase()
        : word[0].toUpperCase() + word.slice(1),
    )
    .join(" ");

const difficultyFromReadme = (directory) => {
  const readmePath = path.join(repositoryRoot, directory, "README.md");
  if (!fs.existsSync(readmePath)) return "—";

  const readme = fs.readFileSync(readmePath, "utf8");
  return readme.match(/<h[23]>\s*(Easy|Medium|Hard)\s*<\/h[23]>/i)?.[1] ?? "—";
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
  const solutionNavigation = problem.solutions
    .map(
      (solution, index) =>
        `<a href="#solution-${index + 1}">${escapeHtml(solution.label)}</a>`,
    )
    .join("");

  const solutionSections = problem.solutions
    .map((solution, index) => {
      const source = fs.readFileSync(path.join(repositoryRoot, solution.directory, solution.fileName), "utf8");
      return `<section id="solution-${index + 1}"><h2>${escapeHtml(solution.label)}</h2><p><a href="../../${encodeURIComponent(solution.directory)}/${encodeURIComponent(solution.fileName)}">View source file</a></p><pre><code>${escapeHtml(source)}</code></pre></section>`;
    })
    .join("\n");

  return `<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>${escapeHtml(`${problem.number}. ${problem.title}`)} · LeetCode Solutions</title>
  <style>
    body { max-width: 980px; margin: 0 auto; padding: 2rem 1rem 4rem; color: #24292f; font: 16px/1.55 system-ui, sans-serif; }
    a { color: #0969da; } header { border-bottom: 1px solid #d0d7de; margin-bottom: 2rem; padding-bottom: 1rem; }
    .meta, nav { display: flex; flex-wrap: wrap; gap: .65rem; align-items: center; } .badge { background: #ddf4ff; border-radius: 999px; padding: .15rem .65rem; }
    nav a { border: 1px solid #d0d7de; border-radius: 6px; padding: .3rem .6rem; text-decoration: none; }
    section { margin-top: 2.5rem; } pre { background: #f6f8fa; border-radius: 6px; overflow: auto; padding: 1rem; } code { font: 13px/1.45 ui-monospace, SFMono-Regular, Menlo, monospace; }
  </style>
</head>
<body>
  <header>
    <p><a href="../../">← All problems</a></p>
    <h1>${escapeHtml(`${problem.number}. ${problem.title}`)}</h1>
    <div class="meta"><span class="badge">${escapeHtml(problem.difficulty)}</span><a href="https://leetcode.com/problems/${encodeURIComponent(problem.slug)}/">Open on LeetCode</a><a href="../../${encodeURIComponent(problem.directory)}/">Problem statement</a></div>
  </header>
  <nav aria-label="Solutions">${solutionNavigation}</nav>
  ${solutionSections || "<p>No supported solution files were found for this problem.</p>"}
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
      return `| [${problem.number}](https://leetcode.com/problems/${problem.slug}/) | [${problem.title}](${siteUrl}/problems/${problem.pageKey}/) | ${problem.difficulty} | ${links} |`;
    })
    .join("\n");

  return `# [![LeetCode](https://img.shields.io/badge/-LeetCode-da8200?style=for-the-badge&logo=LeetCode&logoColor=ffa116&labelColor=black)](https://leetcode.com/Suvraneel/)

<p><b>Documenting my LeetCode journey</b> one problem at a time.</p>

Each solution link opens a readable page with every submitted implementation and variant.

| # | Problem | Difficulty | Solutions |
|---:|:---|:---|:---|
${rows}
`;
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
  console.log(`Generated ${problems.length} problem pages and the solution catalog.`);
};

build();
