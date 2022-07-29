class Solution {
public:
    vector<string> findAndReplacePattern(vector<string>& words, string pattern) {
        vector<string> res;
        map <char, char> m, n;
        for(auto e:words){
            bool valid = true;
            for(int i=0; i<e.size(); i++){
                // cout << m[pattern[i]] << "\t" << e[i] << endl;
                if(m[pattern[i]]){
                    if(m[pattern[i]]!=e[i])
                        valid = false;
                        
                }
                else if(n[e[i]]){
                    if(n[e[i]]!=pattern[i])
                        valid = false;
                        
                }
                else {
                    m[pattern[i]] = e[i];
                    n[e[i]] = pattern[i];
                };
            }
            if (valid){
                res.push_back(e);
                cout << "true" << endl;
            }
            else cout << "false" << endl;
            m.clear();
            n.clear();
        }
        return res;
    }
};