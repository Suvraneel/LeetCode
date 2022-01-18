class Solution {
public:
    bool canPlaceFlowers(vector<int>& flowerbed, int n) {
        if(!(n))
            return true;
        
        if(flowerbed.size()==1)
            return (n==1&&(!(flowerbed[0])));
        
        if (n&&(!(flowerbed[0]|flowerbed[1]))){
            flowerbed[0]=1;
            n--;
        }
        if (n&&(!(flowerbed[flowerbed.size()-1]|flowerbed[flowerbed.size()-2]))){
            flowerbed[flowerbed.size()-1]=1;
            n--;
        }
        if(flowerbed.size()<3)
            return (!(n));
      
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