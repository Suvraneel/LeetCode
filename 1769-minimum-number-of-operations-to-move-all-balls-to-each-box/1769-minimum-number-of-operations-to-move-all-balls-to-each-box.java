class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length(), 
        ltBalls = 0, ltMoves = 0, rtBalls = 0, rtMoves = 0;
        int[] answer = new int[n];
        for(int i=0; i<n; i++){
            answer[i] += ltMoves;
            ltBalls += boxes.charAt(i)-'0';
            ltMoves += ltBalls;
            
            int j = n - 1 - i;
            answer[j] += rtMoves; 
            rtBalls += boxes.charAt(j)-'0';
            rtMoves += rtBalls;
        }
        return answer;
    }
}