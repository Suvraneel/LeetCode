class Solution {
public:
    int minimumCardPickup(vector<int>& cards) {
        map <int, int> m;
        pair<int, int> minima ={-1, INT_MAX};
        for(int i=0; i<cards.size(); i++){
            if(m[cards[i]]){
                if(minima.second>i-m[cards[i]]+1)
                    minima = {cards[i], i-m[cards[i]]+1};
            }
            m[cards[i]]=i+1;
        }
        return minima.second==INT_MAX?-1:minima.second+1;
    }
};