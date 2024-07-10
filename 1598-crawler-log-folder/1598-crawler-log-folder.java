class Solution {
    public int minOperations(String[] logs) {
        int nestingLevel = 0;
        for (String dir : logs) {
            switch (dir) {
                case "../" -> {
                    if (nestingLevel > 0)
                        nestingLevel--;
                }
                case "./" -> {
                }
                default -> nestingLevel++;
            }
        }
        return nestingLevel;
    }
}