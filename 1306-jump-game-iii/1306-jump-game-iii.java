class Solution {
    int[] arr;
    boolean[] vis;

    public boolean canReach(int[] arr, int start) {
        this.arr = arr;
        int n = arr.length;
        this.vis = new boolean[n];
        return move(start);
    }

    private boolean move(int i) {
        if (i < 0 || i >= arr.length || vis[i])
            return false;
        if (arr[i] == 0)
            return true;
        vis[i] = true;
        return move(i + arr[i]) || move(i - arr[i]);
    }
}