class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int n = numberOfUsers, globalMention = 0;
        int[] mentions = new int[n];
        int[] active = new int[n];
        Queue<List<String>> q = new PriorityQueue<>((a, b) -> a.get(1).equals(b.get(1))
                ? b.get(0).compareTo(a.get(0))
                : Integer.parseInt(a.get(1)) - Integer.parseInt(b.get(1))); // tsp asc
        q.addAll(events);
        // System.out.println(q);
        while (!q.isEmpty()) {
            List<String> top = q.poll();
            if (top.get(0).equals("OFFLINE")) {
                active[Integer.parseInt(top.get(2))] = Integer.parseInt(top.get(1)) + 60;
            } else {
                int tsp = Integer.parseInt(top.get(1));
                String[] ids = top.get(2).split(" ");
                for (String id : ids) {
                    if (id.equals("HERE")) {
                        for (int i = 0; i < n; i++)
                            if (active[i] <= tsp)
                                mentions[i]++;
                    } else if (id.equals("ALL"))
                        globalMention++;
                    else
                        mentions[Integer.parseInt(id.substring(2))]++;
                }
            }
        }
        for (int i = 0; i < n; i++)
            mentions[i] += globalMention;
        return mentions;
    }
}