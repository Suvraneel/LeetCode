class Solution {
    public long findScore(int[] nums) {
        LinkedList<int[]> ll = new LinkedList<>();
        int n = nums.length;
        long score = 0;
        for (int i = 0; i < n; i++)
            ll.add(new int[] { nums[i], i });
        ll.sort((a, b) -> a[0] - b[0]);
        while (!ll.isEmpty()) {
            int[] top = ll.poll();
            if (nums[top[1]] == 0)
                continue;
            score += top[0];
            nums[top[1]] = 0;
            if (top[1] > 0)
                nums[top[1] - 1] = 0;
            if (top[1] < n - 1)
                nums[top[1] + 1] = 0;
        }
        return score;
    }
}