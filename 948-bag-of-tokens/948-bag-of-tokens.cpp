class Solution {
public:
    int bagOfTokensScore(vector<int>& tokens, int power) {
        sort(tokens.begin(), tokens.end());
        int start = 0, end = tokens.size()-1, score=0, maxScore=0;
        while(start<=end){
            if(power>=tokens[start]){
                power -= tokens[start];
                score++;
                start++;
                maxScore=max(maxScore, score);
            } else if(score>=1){
                power += tokens[end];
                score--;
                end--;
            } else break;
        }
        return maxScore;
    }
};