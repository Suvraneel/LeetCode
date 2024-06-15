class Solution {
    private static class Project {
        int capital;
        int profit;

        Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int p = 0, n = profits.length;
        List<Project> proj = new ArrayList<>();
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n; i++)
            proj.add(new Project(capital[i], profits[i]));
        Collections.sort(proj, (a, b) -> a.capital - b.capital);
        while (k-- > 0) {
            while (p < n && proj.get(p).capital <= w) {
                pq.add(proj.get(p).profit);
                p++;
            }
            if (pq.isEmpty())
                break;
            w += pq.poll();
        }
        return w;
    }
}