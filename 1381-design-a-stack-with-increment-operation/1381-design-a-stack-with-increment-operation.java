class CustomStack {
    int[] stk;
    int top;
    int capacity;

    public CustomStack(int maxSize) {
        stk = new int[maxSize];
        top = -1;
        capacity = maxSize;
        Arrays.fill(stk, -1);
    }

    public void push(int x) {
        if (top < capacity - 1)
            stk[++top] = x;
    }

    public int pop() {
        if (top == -1)
            return -1;
        int elem = stk[top];
        stk[top--] = -1;
        return elem;
    }

    public void increment(int k, int val) {
        int range = Math.min(k, top + 1);
        for (int i = 0; i < range; i++)
            stk[i] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */