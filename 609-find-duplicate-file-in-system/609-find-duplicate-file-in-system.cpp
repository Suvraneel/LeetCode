class Solution {
public:
    vector<vector<string>> findDuplicate(vector<string>& paths) {
        vector<vector<string>> v;
        map <string, vector<string>> m;
        for(auto p: paths){
            stringstream ss(p);
            string t;
            vector <string> dir = {};
            while(!ss.eof()){
                getline(ss, t, ' ');
                dir.push_back(t);
            }
            for(int i=1; i<dir.size(); i++){
                int idx=dir[i].find('(');
                string fname = dir[i].substr(0, idx);
                string fcontents = dir[i].substr(idx+1);
                m[fcontents].push_back(dir[0]+'/'+fname);
            }
        }
        for(auto vec: m)
            if(vec.second.size()>1)
                v.push_back(vec.second);
        return v;
    }
};