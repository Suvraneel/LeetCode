class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stk = new Stack<>();
        char[] S = s.toCharArray();
        for(char c: S){
            if(c==')'){
                String token = "";
                while(stk.peek()!='(')
                    token += stk.pop();
                stk.pop();
                char[] T = token.toCharArray();
                for(char t: T)
                    stk.push(t);
            } else stk.push(c);
        }
        String ans = "";
        while(!stk.isEmpty())
            ans = stk.pop()+ans;
        return ans;
    }
}