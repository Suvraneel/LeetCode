class Solution {
public:
    int mySqrt(int x) {
        long int lo=0, hi=x, mid, midSq;
        while(lo<hi){
            mid=(hi+lo+1)/2;
            midSq=mid*mid;
            if(midSq==x)
                return mid;
            else if(midSq<x)
                lo=mid;
            else hi=mid-1;
        }
        return (int)(lo+hi)/2;
    }
};