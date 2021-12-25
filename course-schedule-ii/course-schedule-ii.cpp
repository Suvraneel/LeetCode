class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        // find courses without constraint requirements
        int reqments[numCourses];
        bool completed[numCourses];
        vector<int> done;
        for (int i = 0; i < numCourses; i++) {
            reqments[i] = 0;
            completed[i] = false;
        }
        for (int i = 0; i < prerequisites.size(); i++) {
            reqments[prerequisites[i][0]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (reqments[i]==0){    // no requirements, get these courses done first
                done.push_back(i);
                completed[i] = true;
                cout << i <<  " No reqs" << endl;
            }
        }
        int prev = prerequisites.size();
        // keep finishing courses as per `done` fulfilled
        while (!(prerequisites.empty())){
            for (int i = 0; i < prerequisites.size(); i++) {
                if (reqments[prerequisites[i][0]]>0 && completed[prerequisites[i][1]]){
                    cout << prerequisites[i][0] << " Reqs left = " << reqments[prerequisites[i][0]] << endl;
                    if (reqments[prerequisites[i][0]]==1){
                        done.push_back(prerequisites[i][0]);    // requirement fulfilled, so complete that course
                        completed[prerequisites[i][0]] = true; // completed
                    }               
                    reqments[prerequisites[i][0]]--;
                    prerequisites.erase(prerequisites.begin()+i);
                    i--;
                }
            }
            if(prev==prerequisites.size() && (!(prerequisites.empty()))){ //   // not possible, ded end
                cout << prerequisites.size() << " &" << endl;
                done.clear();
                break;
            }
            prev = prerequisites.size();
            cout << prev << " &&" << endl;
        }
        return done;
    }
};