// class Solution {
// public:
//     vector<int> reset(string& p){
//         vector<int> v(26, INT_MIN);
//         for(auto c: p){
//             int i=c-'a';
//             if(v[i]==INT_MIN)
//                 v[i]=0;
//             v[i]++;
//         }
//         return v;
//     }
    
//     vector<int> findAnagrams(string s, string p) {
//         vector<int> ans, v=reset(p);
//         int lt=0, rt=0, ct=0;
//         for(; rt<s.length()-p.length()+1; rt++){
//             cout << s.substr(lt, rt-lt+1) << endl;
//             int a=s[lt]-'a', b=s[rt]-'a';
//             if(v[a]==INT_MIN){
//                 lt++;
//                 continue;
//             }
//             if(v[b]==INT_MIN){
//                 lt=rt+1, ct=0, v=reset(p);
//                 continue;
//             }
//             if(ct>p.length()){
//                 v[a]++, lt++, ct--;
//                 rt--; // to balance the rt++ in the for loop
//                 continue;
//             }
//             v[b]--, ct++;   // increasing sliding win
//             if(v[b]<0){
//                 lt=rt+1, ct=0, v=reset(p);
//                 continue;
//             }
//             if(ct==p.length())
//                 ans.push_back(lt);
//         }
//         return ans;
//     }
// };



class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> pHash(26, 0), winHash(26, 0);
        vector<int> ans;
        if(s.length()<p.length())
            return ans;
        for(auto c: p)
            pHash[c-'a']++;
        for(int lt=0, rt=0; rt<p.length(); rt++)
            winHash[s[rt]-'a']++;
        if(winHash==pHash)
            ans.push_back(0);
        for(int lt=1, rt=p.length(); rt<s.length();lt++, rt++){
            winHash[s[lt-1]-'a']--;
            winHash[s[rt]-'a']++;
            if(winHash==pHash)
                ans.push_back(lt);
        }
        return ans;
    }
};