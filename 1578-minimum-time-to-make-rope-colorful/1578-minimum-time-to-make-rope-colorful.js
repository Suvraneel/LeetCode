/**
 * @param {string} colors
 * @param {number[]} neededTime
 * @return {number}
 */
var minCost = function(colors, neededTime) {
    var res=0;
    for(var i=1, j=0; i<colors.length; i++)
        if(colors[i]==colors[j]){
            if(neededTime[j]>neededTime[i])
                res+=neededTime[i]; // j=j
            else res+=neededTime[j], j=i;
        } else j=i;
    return res;
};