class MinStack {
    Stack<Pair<Integer, Integer>> stk = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        stk.push(new Pair<>(val, Math.min(getMin(), val)));
    }

    public void pop() {
        stk.pop();
    }

    public int top() {
        return stk.peek().getKey();
    }

    public int getMin() {
        if (stk.isEmpty()) // for usage in push method
            return Integer.MAX_VALUE;
        return stk.peek().getValue();
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