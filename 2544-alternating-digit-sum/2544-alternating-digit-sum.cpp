class Solution {
public:
    int alternateDigitSum(int n) {
        int res=0, odd=0, even=0;
        string num = to_string(n);
        for(int i=0; i<num.size(); i+=2)
            odd+=num[i]-'0';
        for(int i=1; i<num.size(); i+=2)
            even+=num[i]-'0';
        return odd-even;
    }
};