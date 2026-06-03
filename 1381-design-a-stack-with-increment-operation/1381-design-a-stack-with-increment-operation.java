class CustomStack {
    int[] stk;
    int size = 0;

    public CustomStack(int maxSize) {
        this.stk = new int[maxSize];
    }

    public void push(int x) {
        if (size == stk.length)
            return;
        stk[size++] = x;
    }

    public int pop() {
        if (size == 0)
            return -1;
        return stk[--size];
    }

    public void increment(int k, int val) {
        k = Math.min(size, k);
        for (int i = 0; i < k; i++)
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