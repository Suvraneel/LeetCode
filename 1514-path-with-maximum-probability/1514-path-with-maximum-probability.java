class Solution {
    int end_node;

    private class Node {
        public int idx;
        public double prob;

        public Node(int idx, double prob) {
            this.idx = idx;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        this.end_node = end_node;
        List<Node>[] adj = new List[n];
        double[] maxProb = new double[n];
        maxProb[start_node] = 1;
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            adj[e[0]].add(new Node(e[1], succProb[i]));
            adj[e[1]].add(new Node(e[0], succProb[i]));
        }
        djikstra(adj, maxProb, start_node);
        return maxProb[end_node];
    }

    private void djikstra(List<Node>[] adj, double[] maxProb, int start_node) {
        Queue<Node> pq = new PriorityQueue<Node>((a, b) -> Double.compare(b.prob,a.prob));
        pq.offer(new Node(start_node, 1));
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            // System.out.println(curr.idx + "\t" + curr.prob);
            for (Node nbr : adj[curr.idx]) {
                double newProb = curr.prob * nbr.prob;
                if (maxProb[nbr.idx] >= newProb)
                    continue;
                maxProb[nbr.idx] = newProb;
                pq.add(new Node(nbr.idx, newProb));
            }
        }
    }
}