/**
 * @param {string[]} paths
 * @return {string[][]}
 */
var findDuplicate = function(paths) {
    var mapper=[], res=[], k=0;
    paths.map((e,i)=>{
        var tokens = e.split(' ');
        for(var i=1; i<tokens.length; i++){
            var f = tokens[i].split('(');   // [1.txt, abcd)]
             mapper[f[1]]=mapper[f[1]]??k++;
            if(!res[mapper[f[1]]])
                res[mapper[f[1]]]=[];
            res[mapper[f[1]]].push(tokens[0]+'/'+f[0]);
            // console.log(res[mapper[f[1]]]);
        }
    })
    // console.log(res);
    return res.filter(e=>{
        return e.length>=2;
    });
};