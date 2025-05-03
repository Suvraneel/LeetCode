class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length, a = tops[0], b = bottoms[0], x;
        for(int i=0; i<n; i++){
            if(tops[i] != a && bottoms[i] != a)
                a = -1;
            if(tops[i] != b && bottoms[i] != b)
                b = -1;
        }
        x = Math.max(a, b);
        if(x == -1)
            return x;
        a = 0;
        b = 0;
        for(int i=0; i<n; i++){
            if(tops[i] == x)
                a++;
            if(bottoms[i] == x)
                b++;
        }
        return Math.min(n - a, n - b);
    }
}