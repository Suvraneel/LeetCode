class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        if(fruits.size()<=2)
            return fruits.size();
        int lt=0, rt=0, change=0, ans=-1;
        vector<int> basket(2,0);
        while(rt<fruits.size()){
            basket[0]=fruits[change];
            lt=change;
            while(rt<fruits.size() && fruits[rt]==fruits[lt])
                rt++;
            if(rt>=fruits.size()){
                ans = max(ans, rt-lt);
                return ans;
            }
            change=rt;
            basket[1]=fruits[rt];
            while(rt<fruits.size() && (fruits[rt]==basket[1] ||  fruits[rt]==basket[0])){
                if(fruits[rt]!=fruits[change])
                    change=rt;
                rt++;
            }
            ans = max(ans, rt-lt);
            // cout << basket[0] << "\t" << basket[1] << "\t(" << lt << ", " << rt << ")\t" << ans << endl;
        }
        return ans;
    }
};