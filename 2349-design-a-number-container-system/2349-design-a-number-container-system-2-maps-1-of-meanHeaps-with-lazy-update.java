class NumberContainers {
    HashMap<Integer, Integer> container;
    HashMap<Integer, PriorityQueue<Integer>> baseIdx;

    public NumberContainers() {
        container = new HashMap<>();
        baseIdx = new HashMap<>();
    }

    public void change(int index, int number) {
        container.put(index, number);
        baseIdx.computeIfAbsent(number, k -> new PriorityQueue<>()).offer(index);
    }

    public int find(int number) {
        while (baseIdx.containsKey(number) && !baseIdx.get(number).isEmpty()) {
            int i = baseIdx.get(number).peek();
            if (container.get(i) == number)
                return i;
            else
                baseIdx.get(number).poll();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */