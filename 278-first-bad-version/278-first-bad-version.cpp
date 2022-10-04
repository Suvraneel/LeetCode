// The API isBadVersion is defined for you.
// bool isBadVersion(int version);

class Solution {
public:
    int firstBadVersion(int n) {
        long int lt=1, rt=n, mid=(lt+rt)/2;
        while(lt<rt){
            if (isBadVersion(mid))
                rt=mid;
            else lt=mid+1;
            mid=(lt+rt)/2;
        }
        return (int)mid;
    }
};