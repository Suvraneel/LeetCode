class AllOne {
    private class Node {
        int freq;
        Node prev;
        Node next;
        Set<String> words;

        Node(int freq, Node prev, Node next) {
            this.freq = freq;
            this.prev = prev;
            this.next = next;
            words = new HashSet<>();
        }
    }

    Map<String, Node> allO1;
    Node head;
    Node tail;

    public AllOne() {
        allO1 = new HashMap<>();
        head = new Node(1, null, null);
        tail = head;
    }

    public void inc(String key) {
        if (allO1.containsKey(key)) { // indicates its current tail node
            Node curr = allO1.get(key);
            Node newNode = curr.next;
            if (newNode == null) {
                newNode = new Node(curr.freq + 1, curr, null);
                curr.next = newNode;
                tail = newNode;
            } else if (newNode.freq > curr.freq + 1) {
                newNode = new Node(curr.freq + 1, curr, curr.next);
                curr.next.prev = newNode;
                curr.next = newNode;
            }
            newNode.words.add(key);
            curr.words.remove(key);
            if (curr != head && curr.words.isEmpty()) { // if oldNode has no words, purge it
                curr.prev.next = newNode;
                newNode.prev = curr.prev;
            }
            allO1.put(key, newNode);
        } else {
            head.words.add(key);
            allO1.put(key, head);
        }
    }

    public void dec(String key) {
        Node curr = allO1.get(key);
        Node newNode = curr.prev;
        if (newNode == null) { // indicates past freq was 1
            allO1.remove(key);
            newNode = head;
        } else if (newNode.freq < curr.freq - 1) {
            newNode = new Node(curr.freq - 1, curr.prev, curr);
            curr.prev.next = newNode;
            curr.prev = newNode;
            allO1.put(key, newNode);
        } else {
            newNode.words.add(key);
            allO1.put(key, newNode);
        }
        curr.words.remove(key);
        if (curr.words.isEmpty()) { // if oldNode has no words, purge it
            newNode.next = curr.next;
            if (curr != tail)
                curr.next.prev = newNode;
            else
                tail = newNode;
        }
    }

    public String getMaxKey() {
        if (tail == null)
            return "";
        Iterator<String> itr = tail.words.iterator();
        return itr.hasNext() ? itr.next() : "";
    }

    public String getMinKey() {
        Node curr = head.words.isEmpty() ? head.next : head;
        if (curr == null)
            return "";
        Iterator<String> itr = curr.words.iterator();
        return itr.hasNext() ? itr.next() : "";
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */