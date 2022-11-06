class Solution {
public:
    string orderlyQueue(string s, int k) {
        if(k==1){
            string res= s;
            for(int i=0; i<s.size(); i++){
                res = min(res, s.substr(i)+s.substr(0,i));
            }
            return res;
        }
        sort(s.begin(), s.end());
        return s;
    }
};