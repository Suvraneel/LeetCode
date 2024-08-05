class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Boolean> distinct = new LinkedHashMap<>();
        for(String s: arr)
            if(!distinct.containsKey(s))
                distinct.put(s, true);
            else distinct.put(s, false);
        for(Map.Entry<String, Boolean> e: distinct.entrySet()){
            if(e.getValue())
                k--;
            if(k==0)
                return e.getKey();
        }
        return "";
    }
}