class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length, grpNum = 0;
        int[] numsSorted = nums.clone(), ans = numsSorted;
        Arrays.sort(numsSorted);
        Map<Integer, Integer> groupIdx = new HashMap<>();
        Map<Integer, Queue<Integer>> groups = new HashMap<>();
        groupIdx.put(numsSorted[0], 0);
        groups.put(0, new LinkedList<>(Arrays.asList(numsSorted[0])));
        for(int i=1; i<n; i++){
            groupIdx.put(numsSorted[i], (numsSorted[i]-numsSorted[i-1]<=limit) ? grpNum: ++grpNum);
            groups.putIfAbsent(grpNum, new LinkedList<>());
            groups.get(grpNum).add(numsSorted[i]);
        }
        for(int i=0; i<n; i++)
            ans[i] = groups.get(groupIdx.get(nums[i])).remove();
        return ans;
    }
}




// class Solution {
//     private class UnionFind {
//         int[] root;
//         int[] rank;

//         UnionFind(int size) {
//             root = new int[size];
//             rank = new int[size];
//             for (int i = 0; i < size; i++) {
//                 root[i] = i;
//                 rank[i] = 1;
//             }
//         }

//         int find(int x) {
//             if (root[x] == x)
//                 return x;
//             return root[x] = find(root[x]);
//         }

//         void union(int x, int y) {
//             int rootX = find(x);
//             int rootY = find(y);
//             if (rootX != rootY) {
//                 if (rank[rootX] < rank[rootY])
//                     root[x] = rootY;
//                 else if (rank[rootX] > rank[rootY])
//                     root[y] = rootX;
//                 else {
//                     root[y] = rootX;
//                     rank[rootX]++;
//                 }
//             }
//         }

//         boolean connected(int x, int y) {
//             return find(x) == find(y);
//         }
//     }

//     public int[] lexicographicallySmallestArray(int[] nums, int limit) {
//         int n = nums.length;
//         UnionFind uf = new UnionFind(n);
//         for (int i = 0; i < n; i++)
//             for (int j = 0; j < n; j++)
//                 if (i!=j && Math.abs(nums[i] - nums[j]) <= limit)
//                     uf.union(i, j);
//         Map<Integer, Queue<Integer>> sets = new HashMap<>();
//         for (int i = 0; i < n; i++) {
//             int root = uf.find(i);
//             sets.putIfAbsent(root, new PriorityQueue<>());
//             sets.get(root).offer(nums[i]);
//         }
//         int[] ans = new int[n];
//         for (int i = 0; i < n; i++)
//             ans[i] = sets.get(uf.find(i)).poll();
//         return ans;
//     }
// }