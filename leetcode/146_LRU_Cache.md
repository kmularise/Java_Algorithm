# 146. LRU Cache
* https://leetcode.com/problems/lru-cache/
* HashMap - 탐색 시 O(1) 보장
* LinkedList - 새로운 데이터를 넣을 때, 가장 오래된 데이터 삭제 시 O(1) 보장
```java
class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    private int capacity;
    private Map<Integer, Node> nodeMap;
    private Node head;
    private Node tail;

    

    public LRUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        }
        Node node = nodeMap.get(key);
        remove(node);
        insertToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            remove(nodeMap.get(key));

        } else {
            if (nodeMap.size() >= capacity) {
                remove(tail.prev);
            }
        }
        insertToHead(new Node(key, value));
    }

    private void insertToHead(Node node) {
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
        nodeMap.put(node.key, node);
    }
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        nodeMap.remove(node.key);
    }
}

```
