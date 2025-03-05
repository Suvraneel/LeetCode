class Solution {
    public long coloredCells(int n) {
        long add = 0, total = 1;
        for(int min = 1; min < n; min++){
            add += 4;
            total += add;
        }
        return total;
    }
}