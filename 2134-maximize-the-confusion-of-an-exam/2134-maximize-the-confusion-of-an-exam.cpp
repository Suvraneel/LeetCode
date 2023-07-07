class Solution {
public:
    int solve(string answerKey, char c, int k){
        int lt=0, rt=0, ct=0, res=0;
        for(int rt=0; rt<answerKey.size(); rt++){
            if(answerKey[rt]==c)
                ct++;
            while(ct>k){  // over-converted (ie, win should be smaller)
                if(answerKey[lt]==c)
                    ct--;   // if leaving char was c, decrement ct
                lt++;   // get out of slidin' win
            }
            res = max(res, rt-lt+1);
        }
        return res;
    }

    int maxConsecutiveAnswers(string answerKey, int k) {
        return max(solve(answerKey, 'T', k), solve(answerKey, 'F', k));
    }
};