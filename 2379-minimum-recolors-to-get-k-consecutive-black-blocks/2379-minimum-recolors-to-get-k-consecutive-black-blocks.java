class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length(), blacks = 0, lt = 0, rt = 0, maxBlacksInKBlocks;
        for (; rt < k; rt++)
            if (blocks.charAt(rt) == 'B')
                blacks++;
        maxBlacksInKBlocks = blacks;
        for (; rt < n; lt++, rt++) {
            if (blocks.charAt(rt) == 'B')
                blacks++;
            if (blocks.charAt(lt) == 'B')
                blacks--;
            maxBlacksInKBlocks = Math.max(maxBlacksInKBlocks, blacks);
        }
        return k - maxBlacksInKBlocks;
    }
}