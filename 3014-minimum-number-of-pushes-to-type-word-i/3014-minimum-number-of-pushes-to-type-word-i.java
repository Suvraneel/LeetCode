class Solution {
    public int minimumPushes(String word) {
        // Since it's given that letters are distinct -> occurs once, any mapping order works.
        int n = word.length(); // distinct mappings to make
        int m = (n - 1) / 8 + 1; // collision indices (max letters in a key)
        return (8 * m * (m - 1) / 2) + (n - 8 * (m - 1)) * m;
    }
}