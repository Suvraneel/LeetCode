class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length, idx = 0;
        List<Integer>[] canMove = new List[n];
        int[] meet = new int[queries.length];
        for (int i = 0; i < n; i++) {
            canMove[i] = new ArrayList<>();
            canMove[i].add(i);
            for (int j = i + 1; j < n; j++)
                if (heights[i] < heights[j])
                    canMove[i].add(j);
        }
        for (int[] q : queries) {
            int lt = 0, rt = 0;
            while (true) {
                if (lt == canMove[q[0]].size() || rt == canMove[q[1]].size()) {
                    meet[idx++] = -1;
                    break;
                }
                if (canMove[q[0]].get(lt) == canMove[q[1]].get(rt)) {
                    meet[idx++] = canMove[q[0]].get(lt);
                    break;
                } else if (canMove[q[0]].get(lt) < canMove[q[1]].get(rt))
                    lt++;
                else
                    rt++;
            }
        }
        return meet;
    }
}