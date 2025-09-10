class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer>[] langSet = new Set[n + 1];
        Set<Integer>[] teach = new Set[n + 1];
        for(int i=0; i<=n; i++)
            teach[i] = new HashSet<>();
        int m = languages.length;
        for (int i = 0; i < m; i++)
            langSet[i] = Arrays.stream(languages[i]).boxed().collect(Collectors.toSet());
        for (int[] f : friendships) {
            Set<Integer> l1 = langSet[f[0] - 1], l2 = langSet[f[1] - 1];
            if (l1.stream().anyMatch(l2::contains))
                continue;
            for(int i=1; i<=n; i++){
                if(!l1.contains(i))
                    teach[i].add(f[0]);
                if(!l2.contains(i))
                    teach[i].add(f[1]);        
            }
        }
        // System.out.println(Arrays.toString(toTeach));
        return Arrays.stream(teach).filter(t -> !t.isEmpty()).map(t -> t.size()).min(Integer::compareTo).orElse(0);
    }
}