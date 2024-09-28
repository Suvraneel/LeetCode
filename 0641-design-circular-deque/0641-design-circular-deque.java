class MyCircularDeque {

    int[] q;
    int size;
    int frontIdx;
    int lastIdx;

    public MyCircularDeque(int k) {
        size = k;
        frontIdx = 1;
        lastIdx = 0;
        q = new int[k];
        Arrays.fill(q, -1);
        // print();
    }

    public boolean insertFront(int value) {
        if (isFull())
            return false;
        frontIdx = (size + frontIdx - 1) % size;
        q[frontIdx] = value;
        // print();
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull())
            return false;
        lastIdx = (lastIdx + 1) % size;
        q[lastIdx] = value;
        // print();
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty())
            return false;
        q[frontIdx] = -1;
        frontIdx = (frontIdx + 1) % size;
        // print();
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty())
            return false;
        q[lastIdx] = -1;
        lastIdx = (size + lastIdx - 1) % size;
        // print();
        return true;
    }

    public int getFront() {
        return q[frontIdx];
    }

    public int getRear() {
        return q[lastIdx];
    }

    public boolean isEmpty() {
        return (size + lastIdx - frontIdx) % size == size - 1 && q[frontIdx] == -1 && q[lastIdx] == -1;
    }

    public boolean isFull() {
        return (size + lastIdx - frontIdx) % size == size - 1 && q[frontIdx] != -1 && q[lastIdx] != -1;
    }

    // private void print() {
    //     System.out.println(Arrays.toString(q) + "\t" + frontIdx + "\t" + lastIdx);
    // }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */