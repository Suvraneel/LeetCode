class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length(), lt = 0, rt = 0, ct = 0;
        char[] cs = s.toCharArray();
        for(; rt<n; rt++){
            cs[lt] = cs[rt];
            if(lt>0 && cs[rt]==')' && cs[lt-1]=='(')
                lt--;
            else lt++;
        }
        return lt;
    }
}