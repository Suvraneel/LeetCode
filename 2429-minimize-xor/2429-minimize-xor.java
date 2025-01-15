class Solution {
    public int minimizeXor(int num1, int num2) {
        int n = num1, srcBitCt = Integer.bitCount(num1), tgtBitCt = Integer.bitCount(num2);
        for(int i=0; srcBitCt<tgtBitCt; i++){
            if(isSet(n, i))
                continue;
            n = setBit(n, i);
            srcBitCt++;
        }
        for(int i=0; srcBitCt>tgtBitCt; i++){
            if(!isSet(n, i))
                continue;
            n = unsetBit(n, i);
            srcBitCt--;
        }
        return n;
    }
    private boolean isSet(int x, int posn){
        return ((x >> posn) & 1) == 1;
    }
    private int setBit(int x, int posn){
        return x | 1 << posn;
    }
    private int unsetBit(int x, int posn){
        return ~(1 << posn) & x;
    }
}