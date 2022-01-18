class Solution {
public:
    bool canPlaceFlowers(vector<int>& flowerbed, int n) {
        if(!(n) || (!(flowerbed.size())))
            return true;
        
        flowerbed.insert(flowerbed.begin(), 0);
        flowerbed.push_back(0);
        
        for(int i=1; i<flowerbed.size()-1; i++){
            if(!(n))
                break;
            if(flowerbed[i-1]|flowerbed[i]|flowerbed[i+1])
                continue;
            n--;
            flowerbed[i]=1;
            cout << i;
        }
        return (!(n));
    }
};