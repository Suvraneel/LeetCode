class MyQueue {
    Stack<Integer> stk1 = new Stack<>();
    Stack<Integer> stk2 = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        while (!stk1.isEmpty())
            stk2.push(stk1.pop());
        stk1.push(x);
    }

    public int pop() {
        while (!stk2.isEmpty())
            stk1.push(stk2.pop());
        return stk1.pop();
    }

    public int peek() {
        while (!stk2.isEmpty())
            stk1.push(stk2.pop());
        return stk1.peek();
    }

    public boolean empty() {
        return stk1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */