package Previous.ByteDance;

import java.util.HashMap;

public class LRUCache {

    class Node {
        public int key;
        public int value;
        public Node next;
        public Node previous;

        public Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoubleList {
        private Node head;
        private Node tail;
        private int size;

        public DoubleList() {
            // 初始化双向链表的数据
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.previous = head;
            size = 0;
        }

        //双链表 API 只能从尾部插入，
        public void addLast(Node node) {
            node.previous = tail.previous;
            node.next = tail;

            tail.previous.next = node;
            tail.previous = node;
            size++;
        }

        public void remove(Node node) {
            node.previous.next = node.next;
            node.next.previous = node.previous;
            size--;
        }

        public Node removeFirst() {
            if(head.next == tail) {
                return null;
            }
            Node first = head.next;
            remove(first);
            return first;
        }

        public int size () {
            return size;
        }
    }

    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int capacity;

    //在方法中初始化map和cache
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            makeRecently(key);
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
//            Node node = map.get(key);
//            node.value = value;
//            map.replace(key,node);
//            makeRecently(key);

            removeKey(key);
            addRecently(key, value);
        }else {
            if(cache.size == capacity) {
                removeLRU();
            }
            addRecently(key, value);
        }


    }

//    由于我们要同时维护一个双链表 cache 和一个哈希表 map，很容易漏掉一些操作，
//    比如说删除某个 key 时，在 cache 中删除了对应的 Node，但是却忘记在 map 中删除 key。
//    解决这种问题的有效方法是：在这两种数据结构之上提供一层抽象 API。
    private void makeRecently(int key) {
        Node node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
    }

    private void addRecently(int key, int value) {
        Node node = new Node(key, value);
        cache.addLast(node);
        map.put(key, node);
    }

    private void removeKey(int key) {
        Node node = map.get(key);
        cache.remove(node);
        map.remove(key);
    }

    private void removeLRU() {
        Node deleteNode = cache.removeFirst();
        map.remove(deleteNode.key);
    }
}

/**
 * Your 字节跳动.LRUCache object will be instantiated and called as such:
 * 字节跳动.LRUCache obj = new 字节跳动.LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */