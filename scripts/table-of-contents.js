// js functions for table of contents
import fetch from 'node-fetch';
import fs from 'fs';
const toc = async () => {
    // fetch from api
    const data = await fetch('https://api.github.com/repos/Suvraneel/Leetcode/contents?ref=main')
        .then(response => response.json())
        .then(data => data);
    var arr = Object.values(data);
    console.log(arr);
    // filter out the folders
    const folders = arr.filter((item) => item.type === 'dir' && item.name[0] !== '.');
    console.log(folders);
    // make a table of contents
    var toc = [];
    folders.forEach((item) => {
        var num = parseInt(item.name.split('-')[0]);
        toc[num] = item.name;
    });
    // sort toc by key
    var sorted = Object.keys(toc).sort().reduce(
        (obj, key) => {
            obj[key] = toc[key];
            return obj;
        }, {});
    console.log(sorted);
    // make markdown
    let markdown = `
# [![LeetCode](https://img.shields.io/badge/-LeetCode-da8200?style=for-the-badge&logo=LeetCode&logoColor=ffa116&labelColor=black)](https://leetcode.com/Suvraneel/)

<p><b>Documenting my LeetCode journey</b> one problem at a time</p>

### [leetcode.com/Suvraneel](https://leetcode.com/Suvraneel/)

---

| Leetcode Problem | Problem Statement | C++ Solution |
|---:|:-----|:----:|
`;
    for (var key in sorted) {
        var str = sorted[key].split('-');
        var name = [];
        for (var i = 1; i < str.length; i++) {
            if(str[i]==="in"|| str[i]==="of" || str[i]==="for" || str[i]==="and" || str[i]==="or" || str[i]==="the" || str[i]==="a" || str[i]==="an" || str[i]==="to" || str[i]==="by" || str[i]==="at" || str[i]==="from" || str[i]==="on" || str[i]==="off" || str[i]==="up" || str[i]==="down" || str[i]==="in" || str[i]==="out" || str[i]==="over" || str[i]==="under" || str[i]==="again" || str[i]==="further" || str[i]==="then" || str[i]==="once" || str[i]==="here" || str[i]==="there" || str[i]==="when" || str[i]==="where" || str[i]==="why" || str[i]==="how" || str[i]==="all" || str[i]==="any" || str[i]==="both" || str[i]==="each" || str[i]==="few" || str[i]==="more" || str[i]==="most" || str[i]==="other" || str[i]==="some" || str[i]==="such" || str[i]==="no" || str[i]==="nor" || str[i]==="not" || str[i]==="only" || str[i]==="own" || str[i]==="same" || str[i]==="so" || str[i]==="than" || str[i]==="too" || str[i]==="very" || str[i]==="s" || str[i]==="t" || str[i]==="can" || str[i]==="will" || str[i]==="just" || str[i]==="don" || str[i]==="should" || str[i]==="now")
                name[i] = str[i].toLowerCase();
            else if(str[i][0]==="i" && str[i].length<=3)
                name[i] = str[i].toUpperCase();
            else name[i] = str[i].charAt(0).toUpperCase() + str[i].slice(1);
        }
        name = name.join(' ').trim();
        name = name.charAt(0).toUpperCase() + name.slice(1);
        var num = key;
        if (num[0]>='0'&&num[0]<='9')
            markdown += `| [${num}](https://leetcode.com/problems/${str.slice(1).join('-')}/) | [${name}](./${str.join('-')}) | **[Solution](./${str.join('-')}/${str.join('-')}.cpp)**  \n`;
    };

    // write to file
    fs.writeFile('../README.md', markdown, (err) => {
        if (err) throw err;
        console.log('The file has been saved!');
    });
}

toc();