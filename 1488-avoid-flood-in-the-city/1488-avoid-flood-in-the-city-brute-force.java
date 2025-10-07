class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> seen = new HashMap<>();
        Queue<Integer> blank = new PriorityQueue<>((a, b) -> b - a);
        for (int i = n - 1; i >= 0; i--) {
            if (rains[i] > 0) {
                if (seen.containsKey(rains[i])) {
                    int lastSeen = seen.get(rains[i]);
                    List<Integer> reserve = new ArrayList<>();
                    while (!blank.isEmpty() && blank.peek() > lastSeen) {
                        // System.out.println(blank + "\t" + lastSeen);
                        reserve.add(blank.poll());
                    }
                    if (blank.isEmpty())
                        return new int[0];
                    else
                        ans[blank.poll()] = rains[i];
                    blank.addAll(reserve);
                }
                seen.put(rains[i], i);
                ans[i] = -1;
            } else
                blank.offer(i);
        }
        while (!blank.isEmpty())
            ans[blank.poll()] = 1;
        return ans;
    }
}