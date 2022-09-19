class Solution {
public:
    vector<vector<string>> findDuplicate(vector<string>& paths) {
        vector<vector<string>> v;
        map <string, int> m;
        int k=1;
        for(auto p: paths){
            stringstream ss(p);
            string t;
            vector <string> dir = {};
            while(!ss.eof()){
                getline(ss, t, ' ');
                dir.push_back(t);
            }
            for(int i=1; i<dir.size(); i++){
                stringstream ss(dir[i]);
                string x;
                vector <string> tok = {};
                while(!ss.eof()){
                    getline(ss, x, '(');
                    tok.push_back(x);
                }
                if(!m[tok[1]])
                    m[tok[1]]=k++;
                if(m[tok[1]]>v.size())
                    v.push_back({});
                v[m[tok[1]]-1].push_back(dir[0]+'/'+tok[0]);
            }
        }
        vector<vector<string>>res;
        for(auto vec: v)
            if(vec.size()>1)
                res.push_back(vec);
        return res;
    }
};