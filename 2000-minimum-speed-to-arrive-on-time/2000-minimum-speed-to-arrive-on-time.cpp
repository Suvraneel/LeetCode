class Solution
{
    bool canReachInTime(const vector<int>& dist, const double hour, int speed)
    {
        double time = 0;
        for (int i = 0; i < dist.size() - 1; ++i)
            time += ceil((double)dist[i] / speed);
        
        time += ((double)dist.back()) / speed;
        return time <= hour;
    }
    
public:
    int minSpeedOnTime(vector<int>& dist, double hour)
    {
        if (hour <= dist.size()-1)
            return -1;
        
        int lo = 1, hi = 1e7, mid;
        while (lo < hi)
        {
            mid = (lo + hi) / 2;
            if (canReachInTime(dist, hour, mid))
                hi = mid;
            else
                lo = mid + 1;
        }
        return hi;
    }
};