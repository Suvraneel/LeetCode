class Solution {
public:
    string removeDigit(string number, char digit) {
        string maxm = "";
        for(int i=0; i<number.length(); i++){
            if(number[i]==digit){
                string temp = number.substr(0,i)+number.substr(i+1, number.length()-1); 
                maxm = max(maxm, temp);
            }
        }
        return maxm;
    }
};