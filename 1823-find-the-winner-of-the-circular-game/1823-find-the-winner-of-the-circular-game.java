class Solution {
    public int findTheWinner(int n, int k) {
        int start = 0;
        List<Integer> table = IntStream.range(1, n+1).boxed().collect(Collectors.toList());
        while (table.size() > 1) {
            start = (start + k - 1) % table.size();
            table.remove(start);
            // System.out.println(table.toString());
        }
        return table.get(0);
    }
}