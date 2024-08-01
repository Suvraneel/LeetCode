class Solution {
    public int countSeniors(String[] details) {
        int ct = 0;
        for(String passenger: details)
            if(Integer.parseInt(passenger.substring(11,13))>60)
                ct++;
        return ct;
    }
}