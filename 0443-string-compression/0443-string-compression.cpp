class Solution {
public:
    int compress(vector<char>& chars) {
        int idx = 0, j = 0, sz = size(chars);
        while(j < sz){
            char ch = chars[j];
            int cnt = 0;

            while(j < sz and chars[j] == ch) j++, cnt++;

            chars[idx++] = ch;
            if(cnt > 1){
                int pw = pow(10, (int)log10(cnt));
                while(pw > 0){
                    chars[idx++] = (cnt / pw % 10) + '0';
                    pw /= 10;
                }
            }
        }
        return idx;
    }
};