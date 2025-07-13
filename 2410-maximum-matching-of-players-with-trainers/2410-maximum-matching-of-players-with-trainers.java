class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int m = players.length, n = trainers.length, ct = 0;
        for (int i = m - 1, j = n - 1; i >= 0 && j >= 0; j--) {
            while (i >= 0 && players[i] > trainers[j])
                i--;
            if (i >= 0) {
                ct++;
                i--;
            }
        }
        return ct;
    }
}