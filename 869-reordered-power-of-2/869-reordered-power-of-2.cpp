class Solution {
public:
    string sorter(string s){
        sort(s.begin(), s.end());
        return s;
    }
    
    bool reorderedPowerOf2(int n) {
        int x = 1;
        string s = sorter(to_string(n));
        for (int i=0; i<30; i++){
            if(s==sorter(to_string(x)))
                return true;
            x <<= 1;
        }
        return false;
    }
};