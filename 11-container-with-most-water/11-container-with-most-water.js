var maxArea = function(ht) {
    var maxm=0, lt=0, rt=ht.length-1;
    while(lt<rt){
        maxm = Math.max(maxm,(rt-lt)*Math.min(ht[lt], ht[rt]));
        if(ht[lt]<ht[rt])
            lt++;
        else rt--;
    }
    return maxm;
};