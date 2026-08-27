class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node() {}

        public Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }

    Node head;
    Node tail;
    HashMap<Integer, Node> hp;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hp = new HashMap<>();

        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!hp.containsKey(key)) {
            return -1;
        }

        Node node = hp.get(key);

        
        remove(node);
        addFront(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (hp.containsKey(key)) {
            Node node = hp.get(key);

            node.value = value;

            remove(node);
            addFront(node);
        }

      
        else {
            if (hp.size() >= capacity) {
               
                Node lru = tail.prev;

                remove(lru);
                hp.remove(lru.key);
            }

            Node newNode = new Node(key, value);

            hp.put(key, newNode);
            addFront(newNode);
        }
    }

    public void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    public void addFront(Node n) {
        n.prev = head;
        n.next = head.next;

        head.next.prev = n;
        head.next = n;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */