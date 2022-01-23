class Solution {
public:
    vector<int> sequentialDigits(int low, int high) {
        string lo = to_string(low), hi = to_string(high);
        vector<int> v;
        for (int i = lo.length(); i <= hi.length(); i++){
            if(i == hi.length())   
                for (int j = (lo.length()==hi.length() ? lo[0]-'0':1); j <= hi[0]-'0'; j++){
                    long k = stol(create(j, i));
                    if(k>=low && k <= high)
                        v.push_back((int)k);
                }
            else{
                for (int j = lo[0]-'0'; j <= 9-i+1; j++){
                    int k = stoi(create(j, i));
                    if(k>=low)
                        v.push_back(k);
                }
            }
        }
        return v;
    }
    
    string create(int msb, int size){
        string s = "";
        for(int i=0; i<size; i++){
            s += to_string(msb+i);
        }
        return s;
    }
};