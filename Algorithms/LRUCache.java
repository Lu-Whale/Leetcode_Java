package Algorithms;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LRUCache {
    public int capacity;
    public LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>();
    }

    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            cache.put(key, value);
            makeRecently(key);
        }else {
            cache.put(key, value);
            if(cache.size() > capacity) {
                int evictKey = cache.keySet().iterator().next();
                cache.remove(evictKey);
            }
        }
    }

    public void makeRecently(int key) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }
}

class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node() {}

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class DoubleList {
    int size;
    Node head;
    Node tail;

    public DoubleList() {
        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;

        size = 0;
    }

    public void addLast(Node node) {
        node.prev = tail.prev;
        node.next = tail;

        tail.prev.next = node;
        tail.prev = node;
        size++;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public Node removeFirst() {
        Node first = head.next;
        remove(first);
        return first;
    }

    public int getSize() {
        return size;
    }
}

class LRU {
    DoubleList list;
    HashMap<Integer, Node> map;
    int cap;

    public LRU(int cap) {
        list = new DoubleList();
        map = new HashMap<>();
        this.cap = cap;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            makeRecently(key);
            return map.get(key).val;
        }else {
            return -1;
        }
    }

    public void put(int key, int val) {
        if(map.containsKey(key)) {
            remove(key);
            addRecently(key, val);
        }else {
            addRecently(key, val);
            if(list.size > cap) {
                removeFirst();
            }
        }
    }

    private void makeRecently(int key) {
        Node node = map.get(key);
        list.remove(node);
        list.addLast(node);
    }

    private void remove(int key) {
        Node node = map.get(key);
        list.remove(node);
        map.remove(key);
    }

    private void addRecently(int key, int val) {
        Node node = new Node(key, val);
        list.addLast(node);
        map.put(key, node);
    }

    private void removeFirst() {
        Node node = list.removeFirst();
        map.remove(node.key);
    }
}


