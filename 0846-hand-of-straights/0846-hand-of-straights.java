class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0)
            return false;
        int nGrps = hand.length/groupSize;
        Map<Integer, Integer> freq = new TreeMap<>();
        for(int i:hand)
            freq.put(i, freq.getOrDefault(i, 0)+1);
        for(int i=0; i<nGrps; i++){
            int grpSizeCt = 0, prev = -1;
            for(Map.Entry<Integer, Integer> e: freq.entrySet()){
                if(e.getValue()==0)
                    continue;
                if(prev==-1)
                    prev = e.getKey();
                else if(e.getKey()!=prev+1)
                    return false;
                e.setValue(e.getValue()-1);
                prev = e.getKey();
                if(++grpSizeCt==groupSize)
                    break;
            }
            if(grpSizeCt<groupSize)
                return false;
        }
        return true;
    }
}