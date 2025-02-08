class NumberContainers {
    HashMap<Integer, Integer> container;
    HashMap<Integer, TreeSet<Integer>> baseIdx;

    public NumberContainers() {
        container = new HashMap<>();
        baseIdx = new HashMap<>();
    }

    public void change(int index, int number) {
        if (container.containsKey(index))
            baseIdx.get(container.get(index)).remove(index);
        container.put(index, number);
        baseIdx.putIfAbsent(number, new TreeSet<>());
        baseIdx.get(number).add(index);
    }

    public int find(int number) {
        if (baseIdx.containsKey(number) && !baseIdx.get(number).isEmpty())
            return baseIdx.get(number).first();
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */