class KthLargest {
    int k;
    Queue<Integer> stream; // minHeap Impl

    public KthLargest(int k, int[] nums) {
        this.k = k;
        stream = new PriorityQueue<>();
        for (int i : nums)
            stream.offer(i);
        while (stream.size() > k)
            stream.poll();
    }

    public int add(int val) {
        if (stream.size() < k || stream.peek() < val) {
            stream.offer(val);
            while (stream.size() > k)
                stream.poll();
        }
        return stream.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */