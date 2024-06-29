class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Set<Integer>[] ancestors = new TreeSet[n];
        Queue<Integer> processed = new LinkedList<>();
        for(int i=0; i<n; i++)
            ancestors[i] = new TreeSet<>();
        for(int[] e: edges)
            ancestors[e[1]].add(e[0]);
        for(int i=0; i<n; i++)
            if(ancestors[i].isEmpty())
                processed.add(i);
        while(!processed.isEmpty()){
            // System.out.println(processed.toString());
            int p = processed.poll();
            for(int i=0; i<n; i++){
                if(ancestors[i].contains(p)){
                    ancestors[i].addAll(ancestors[p]);
                    processed.add(i);
                }
            }
        }
        return Arrays.stream(ancestors).map(ArrayList::new).collect(Collectors.toList());
    }
}