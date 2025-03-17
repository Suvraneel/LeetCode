class Solution {
    public boolean divideArray(int[] nums) {
        Set<Integer> lone = new HashSet<>();
        for (int i : nums)
            if (lone.contains(i))
                lone.remove(i);
            else
                lone.add(i);
        return lone.isEmpty();
    }
}