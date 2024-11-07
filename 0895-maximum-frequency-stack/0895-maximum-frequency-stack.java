class FreqStack {
    Map<Integer, Integer> freq = new HashMap<>();
    TreeMap<Integer, Stack<Integer>> m = new TreeMap<>();

    public FreqStack() {

    }

    public void push(int val) {
        int newFreq = freq.getOrDefault(val, 0) + 1;
        freq.put(val, newFreq);
        m.putIfAbsent(newFreq, new Stack<>());
        m.get(newFreq).push(val);
    }

    public int pop() {
        int mostFreq = m.lastKey(), elem = m.get(mostFreq).pop();
        if (m.get(mostFreq).isEmpty())
            m.remove(mostFreq);
        freq.put(elem, freq.get(elem) - 1);
        return elem;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */