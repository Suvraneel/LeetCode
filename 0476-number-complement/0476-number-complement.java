class Solution {
    public int findComplement(int num) {
        int complement2s = 2, n = num;
        while(n>>1!=0){
            n>>=1;
            complement2s <<= 1;
        }
        return complement2s - 1 - num;
    }
}