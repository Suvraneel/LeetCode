class Solution {
public:
    int solve(string answerKey, char c, int k){
        int lt=0, rt=0, ct=0, res=0;
        for(int rt=0; rt<answerKey.size(); rt++){
            if(answerKey[rt]==c)
                ct++;   // ie, converting F -> T
            while(ct>k){  // over-converted
                if(answerKey[lt]==c)
                    ct--;   // get out of slidin' win
                lt++;   // win shift
            }
            res = max(res, rt-lt+1);
        }
        return res;
    }

    int maxConsecutiveAnswers(string answerKey, int k) {
        return max(solve(answerKey, 'T', k), solve(answerKey, 'F', k));
    }
};