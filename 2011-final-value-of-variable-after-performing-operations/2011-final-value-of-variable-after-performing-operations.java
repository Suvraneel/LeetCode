class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String ops : operations)
            switch (ops.charAt(1)) {
                case '+' -> x++;
                case '-' -> x--;
            }
        return x;
    }
}