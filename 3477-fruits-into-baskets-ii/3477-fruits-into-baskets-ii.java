class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int rem = fruits.length;
        for(int f: fruits){
            for(int i=0; i<baskets.length; i++)
                if(baskets[i]>=f){
                    rem--;
                    baskets[i] = 0;
                    break;
                }
        }
        return rem;
    }
}