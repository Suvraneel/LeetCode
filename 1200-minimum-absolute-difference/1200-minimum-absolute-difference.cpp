class Solution {
public:
    vector<vector<int>> minimumAbsDifference(vector<int>& arr) {
        vector<vector<int> > res;
        int diff = INT_MAX;
        sort(arr.begin(), arr.end());
        for(int i = 1; i < arr.size(); i++){
            int temp = arr[i]-arr[i-1];
            cout << "$" << temp << endl;
            if (temp>diff)
                continue;
            if (temp<diff){
                diff = temp;
                res.clear();
            }
            if (temp<=diff)
                res.push_back({arr[i-1],arr[i]});
        }
        return res;
    }
};