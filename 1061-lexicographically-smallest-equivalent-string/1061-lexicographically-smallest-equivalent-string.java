class Solution {
    private class UnionFind {
        int[] root;

        UnionFind(int size) {
            root = new int[size];
            for (int i = 0; i < size; i++)
                root[i] = i;
        }

        int find(int x) {
            if (x == root[x])
                return x;
            return find(root[x]);
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rootX < rootY)
                    root[rootY] = rootX;
                else
                    root[rootX] = rootY;
            }
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length(), len = baseStr.length();
        UnionFind uf = new UnionFind(26);
        for (int i = 0; i < n; i++) {
            int c1 = s1.charAt(i) - 'a', c2 = s2.charAt(i) - 'a';
            uf.union(c1, c2);
        }
        char[] cs = baseStr.toCharArray();
        for (int i = 0; i < len; i++)
            cs[i] = (char) ('a' + uf.find(cs[i] - 'a'));
        return new String(cs);
    }
}