class Solution {
    public List<Integer> survivedRobotsHealths(
            int[] positions, int[] healths, String directions) {
        List<Integer> ans = new ArrayList<>();
        char[] dir = directions.toCharArray();
        int[] indices = IntStream.range(0, positions.length).boxed().sorted(
                Comparator.comparingInt(i -> positions[i])).mapToInt(Integer::intValue).toArray();
        Stack<Integer> stk = new Stack<>();
        int top;
        for (int i, j = 0; j < positions.length; j++) {
            i = indices[j];
            if (stk.empty() || dir[i] == 'R')
                stk.push(i);
            else if (healths[i] > 0) {
                top = stk.pop();
                if (dir[i] == dir[top]) {
                    stk.push(top);
                    stk.push(i);
                } else if (healths[i] == healths[top]) {
                    healths[i] = healths[top] = 0;
                } else if (healths[i] < healths[top]) {
                    healths[i] = 0;
                    healths[top]--;
                    stk.push(top);
                } else {
                    healths[i]--;
                    healths[top] = 0;
                    j--;
                }
            }
            System.out.println(stk.toString());
        }

        for (int h : healths)
            if (h != 0)
                ans.add(h);
        return ans;
    }
}