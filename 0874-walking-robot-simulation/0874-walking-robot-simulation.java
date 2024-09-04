class Solution {
    private static int[][] directions = {
            { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } // N E S W
    };

    private static int getId(int i, int j) {
        return (int) (j * 10e4 + i);
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Integer> obs = new HashSet<>(
                Arrays.stream(obstacles).map(pt -> getId(pt[0], pt[1]))
                        .collect(Collectors.toList()));
        int x = 0, y = 0, dir = 0, maxDist = 0;
        for (int cmd : commands) {
            switch (cmd) {
                case -1 -> dir = (dir + 1) % 4;
                case -2 -> dir = (4 + dir - 1) % 4;
                default -> {
                    int[] move = directions[dir];
                    for (int i = 0; i < cmd; i++) {
                        int newX = x + move[0];
                        int newY = y + move[1];
                        if (obs.contains(getId(newX, newY)))
                            break;
                        x = newX;
                        y = newY;
                    }
                    // System.out.println("(" + x + "," + y + ")");
                    maxDist = Math.max(maxDist, x*x + y*y);
                }
            }
        }
        return maxDist;
    }
}