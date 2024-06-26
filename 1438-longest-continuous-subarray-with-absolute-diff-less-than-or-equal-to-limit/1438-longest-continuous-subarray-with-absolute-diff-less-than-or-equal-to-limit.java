class Solution {
    private class DblPriorityQ {
        TreeMap<Integer, Integer> pq = new TreeMap<>();

        public DblPriorityQ() {
        }

        public void insert(int key) {
            this.pq.put(key, this.pq.getOrDefault(key, 0) + 1);
        }

        public int getMin() {
            return this.pq.firstEntry().getKey();
        }

        public int getMax() {
            return this.pq.lastEntry().getKey();
        }

        public void remove(int key) {
            int freq = this.pq.get(key);
            if (freq > 1)
                this.pq.put(key, freq - 1);
            else
                this.pq.remove(key);
        }

        public int findAbsDiff() {
            return (getMax() - getMin());
        }

        public String toString() {
            StringBuilder buffer = new StringBuilder();
            for (Map.Entry<Integer, Integer> e : this.pq.entrySet())
                for (int i = 0; i < e.getValue(); i++)
                    buffer.append(e.getKey()).append(", ");
            if (buffer.length() > 0)
                buffer.setLength(buffer.length() - 2);
            return buffer.toString();
        }
    }

    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length, lt = 0, rt = 0, maxLen = 0;
        DblPriorityQ pq = new DblPriorityQ();
        while (rt < n) {
            pq.insert(nums[rt++]);
            while (pq.findAbsDiff() > limit)
                pq.remove(nums[lt++]);
            maxLen = Math.max(maxLen, rt - lt);
            // System.out.println(pq.toString());
        }
        return maxLen;
    }
}