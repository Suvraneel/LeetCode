/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private static final int[][] clock = {
            { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }
    };

    private boolean isValid(int i, int j, int m, int n, int[][] mat) {
        if (i < 0 || i >= m || j < 0 || j >= n || mat[i][j] != -1)
            return false;
        return true;
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(mat[i], -1);
        int r = 0, c = 0, dir = 0, i = 0, j = 0;
        while (head != null) {
            // System.out.println(i + "\t" + j);
            if (isValid(i, j, m, n, mat)) {
                r = i;
                c = j;
                mat[r][c] = head.val;
                head = head.next;
            } else
                dir = (dir + 1) % 4;
            i = r + clock[dir][0]; 
            j = c + clock[dir][1];
        }
        return mat;
    }
}