class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        int lt=0, rt=0, len=0;
        queue<int> q; // flipped indices
        while(rt<nums.size()){
            while(q.size()<=k){
                while(rt<nums.size() && nums[rt])
                    rt++;
                q.push(rt++);
            }
            cout << "(" << lt << ", " << rt << ")\t" << rt-1-lt << endl;
            len=max(len, rt-1-lt);
            lt=q.front()+1;
            q.pop();
        }
        return min(len, (int)nums.size());
    }
};