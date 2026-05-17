class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] vis = new boolean[n];
        return move(arr, vis, start);
    }

    private boolean move(int[] arr, boolean[] vis, int i) {
        if (i < 0 || i >= arr.length || vis[i])
            return false;
        if (arr[i] == 0)
            return true;
        vis[i] = true;
        return move(arr, vis, i + arr[i]) || move(arr, vis, i - arr[i]);
    }
}