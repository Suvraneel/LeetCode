class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;
        int nGrps = hand.length / groupSize;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : hand)
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        for(int i: hand){
            int start = i;
            while(freq.getOrDefault(start-1,0)!=0)   // find safe streak start
                start--;
            while(start<i){
                while(freq.getOrDefault(start, 0)!=0){
                    for(int curr = start; curr<start+groupSize; curr++){
                        if(freq.getOrDefault(curr,0)==0)    // incomplete streak
                            return false;
                        freq.put(curr, freq.get(curr)-1);
                    }
                }
                start++;
            }
        }
        return true;
    }
}