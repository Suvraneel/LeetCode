class Solution {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        char[] cs = s.toCharArray();
        for(int i=0; i<n; i++){
            for(int j = i+1; j<n; j++){
                if(cs[j]>cs[i]){
                    char temp = cs[i];
                    cs[i] = cs[j];
                    cs[j] = temp;
                    return Integer.parseInt(Stream.of(cs).map(arr -> new String(arr)).collect(Collectors.joining()));
                }
            }
        }
        return num;
    }
}