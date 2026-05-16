class Solution {
    private class UnionFind {
        Map<Integer, Integer> root = new HashMap<>();
        Map<Integer, Integer> rank = new HashMap<>();

        UnionFind(int[] nums) {
            for (int i : nums) {
                root.put(i, i);
                rank.put(i, 1);
            }
        }

        private int find(int x) {
            int rootX = root.get(x);
            if (rootX == x)
                return x;
            int head = find(rootX);
            root.put(x, head);
            return head;
        }

        private void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                int rankX = rank.get(x), rankY = rank.get(y);
                if (rankX < rankY)
                    root.put(rootY, rootX);
                else if (rankX > rankY)
                    root.put(rootX, rootY);
                else {
                    root.put(rootY, rootX);
                    rank.put(rootX, rank.get(rootX) + 1);
                }
            }
        }

        private boolean connected(int x, int y) {
            return find(x) == find(y);
        }

        private boolean validKey(int x) {
            return root.containsKey(x);
        }

        private int getMaxFreq() {
            Map<Integer, Integer> freq = new HashMap<>();
            for (Integer key : root.keySet()) {
                int head = find(key);
                freq.put(head, freq.getOrDefault(head, 0) + 1);
            }
            int ans = 0;
            for (Integer value : freq.values())
                ans = Math.max(ans, value);
            return ans;
        }
    }

    public int longestConsecutive(int[] nums) {
        UnionFind uf = new UnionFind(nums);
        for (int i : nums) {
            if (uf.validKey(i - 1))
                uf.union(i, i - 1);
            if (uf.validKey(i + 1))
                uf.union(i, i + 1);
        }
        // System.out.println(uf.root);
        return uf.getMaxFreq();
    }
}