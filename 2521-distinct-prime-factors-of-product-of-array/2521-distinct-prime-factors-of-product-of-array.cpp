class Solution {
public:
    unordered_set<int> f;
    void primeFactors(int n){
        int c=2;
        while(n>1){
            if(n%c==0){
            f.insert(c);
            n/=c;
            }
            else c++;
        }
    }
    
    int distinctPrimeFactors(vector<int>& nums) {
        for(auto e:nums)
            primeFactors(e);
        return f.size();
    }
};