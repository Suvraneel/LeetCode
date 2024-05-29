class Solution {
    public int numSteps(String s) {
        char[] S = s.toCharArray();
        int N = S.length, cy = 0, ct = 0;
        for (int i = N - 1; i > 0; i--) {
            if (cy == 1) {
                if (S[i] == '0') {
                    S[i] = '1';
                    cy = 0;
                } else
                    S[i] = '0';
            }
            if (S[i] == '1') {
                S[i] = '0';
                cy = 1;
                ct += 2;
            } else
                ct++;
        }
        if (cy == 1){
            if(S[0]=='1')
                ct++;
            else ct+=2;
        }
        return ct;
    }
}