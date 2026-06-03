class MyCircularQueue {

    int[] q;
    int front = 0, rear = 0;
    int size = 0;

    public MyCircularQueue(int k) {
        this.q = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;
        q[rear] = value;
        size++;
        rear = (rear + 1) % q.length;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;
        front = (front + 1) % q.length;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;
        return q[front];
    }

    public int Rear() {
        if (isEmpty())
            return -1;
        return q[(q.length + rear - 1) % q.length];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == q.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */