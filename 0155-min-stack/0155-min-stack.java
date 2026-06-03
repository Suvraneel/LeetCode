class MinStack {
    Stack<Integer> stk = new Stack<>();
    TreeMap<Integer, Integer> m = new TreeMap<>();

    public MinStack() {

    }

    public void push(int val) {
        stk.push(val);
        m.put(val, m.getOrDefault(val, 0) + 1);
    }

    public void pop() {
        int val = stk.pop();
        m.put(val, m.get(val) - 1);
        if (m.get(val) == 0)
            m.remove(val);
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        return m.firstKey();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */