/**
 * @param {string} pattern
 * @param {string} s
 * @return {boolean}
 */
var wordPattern = function(pattern, s) {
    var v = s.split(' ');
    if(v.length!==pattern.length)
        return false;
    var map1 = {};
    var map2 = {};
    for(var i=0; i<pattern.length; i++){
        if(!(pattern[i] in map1) && !(v[i] in map2)){
            map1[pattern[i]] = v[i];
            map2[v[i]] = pattern[i];
        }
        else if(map1[pattern[i]]!==v[i] || map2[v[i]]!==pattern[i])
            return false;
    }
    return true;
};