class Solution {
    public int[] frequencySort(int[] nums) {
        int[] freq = new int[201];
        for(int n: nums)
            freq[n+100]++;
        Integer[] ans = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(ans, (a, b) -> {
            if(freq[a+100]==freq[b+100])
                return b - a;
            return freq[a+100] - freq[b+100];
        });
        return Arrays.stream(ans).mapToInt(Integer::intValue).toArray();
    }
}