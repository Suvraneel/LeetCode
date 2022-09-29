class Solution {
public:
    struct comparator{
        int x;
        comparator(int x){
            this->x=x;
        }
        bool operator ()(int a, int b){
            return abs(a-x)<abs(b-x);
        }
    };
    
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        if(arr.size()==1) return arr;
        stable_sort(arr.begin(), arr.end(), comparator(x));
        // arr=vector<int>(arr.begin(),arr.begin()+k);
        arr.erase(arr.begin()+k, arr.end());
        sort(arr.begin(), arr.end());
        return arr;
    }
};