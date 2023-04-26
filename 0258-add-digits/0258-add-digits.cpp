class Solution {
public:
    int addDigits(int num) {
        int n=0;
        while(num>9){
            while(num){
                n+=num%10;
                cout << n;
                num/=10;
            }
            num=n;
            n=0;
        }
        return num;
    }
};