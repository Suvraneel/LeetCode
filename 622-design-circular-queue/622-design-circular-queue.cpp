class MyCircularQueue {
public:       
    vector<int> q;
    int lt=0, rt=0, k=0;
    
    MyCircularQueue(int capacity){
        k = capacity;
        q.resize(k,-1);
    }
    
    bool enQueue(int value) {
        if(isFull())
            return false;
        q[rt++]=value;
        rt%=k;
        return true;
    }
    
    bool deQueue() {
        if(isEmpty())
            return false;
        q[lt++]=-1;
        lt%=k;
        return true;
    }
    
    int Front() {
        return q[(k+lt)%k];
    }
    
    int Rear() {
        return q[(k+rt-1)%k];
    }
    
    bool isEmpty() {
        return lt==rt && q[(k+lt-2)%k]==-1;
    }
    
    bool isFull() {
        return rt==lt && q[(k+lt-2)%k]!=-1;
    }
};

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue* obj = new MyCircularQueue(k);
 * bool param_1 = obj->enQueue(value);
 * bool param_2 = obj->deQueue();
 * int param_3 = obj->Front();
 * int param_4 = obj->Rear();
 * bool param_5 = obj->isEmpty();
 * bool param_6 = obj->isFull();
 */