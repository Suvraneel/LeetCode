class Solution {
public:
    void convert (string &s, int start, int end, char x){
        for(int i=start+1; i<end; i++){
            s[i] = x;
            // cout << x;
        }
    }
    string pushDominoes(string s) {
        char prev='L';
        int prev_i=-1;
        for(int i=0; i<s.size(); i++){
            // cout << s[i];
            if (s[i]=='L' && prev=='L')
                convert(s, prev_i, i, 'L');
            else if (s[i]=='R' && prev=='R')
                convert(s, prev_i, i, 'R');
            else if (s[i]=='R' && prev=='L');
                // Do Nothing
            else if (s[i]=='L' && prev=='R'){
                int streak = i - prev_i;
                convert(s, prev_i, prev_i + ceil(streak/2.0), 'R');
                convert(s, prev_i + floor(streak/2.0), i, 'L');
            }
            if(s[i]!='.'){
                prev = s[i];
                prev_i = i;
            }
        }
        // cout << prev_i << "->" << prev << endl;
        if (prev=='R' && prev_i<s.size()){
            convert(s, prev_i, s.size(), 'R');
        }
        return s;
    }
};