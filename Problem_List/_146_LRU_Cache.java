package Problem_List;

import java.util.LinkedHashMap;
import java.util.Map;

public class _146_LRU_Cache {

}

class LRUCache {

    private int capacity;
    private LinkedHashMap<Integer, Integer> linkedHashMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        linkedHashMap = new LinkedHashMap<>();
    }

    public int get(int key) {
        if(linkedHashMap.containsKey(key)) {
            makeRecently(key);
            return linkedHashMap.get(key);
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(linkedHashMap.containsKey(key)) {
            linkedHashMap.replace(key, value);
            makeRecently(key);
        }else {
            linkedHashMap.put(key, value);

            if(linkedHashMap.size() > capacity) {
//                int oldKey = 0;
//                for(int k: linkedHashMap.keySet()) {
//                    oldKey = k;
//                    break;
//                }
                int oldKey = linkedHashMap.keySet().iterator().next();
                linkedHashMap.remove(oldKey);
            }
        }
    }

    private void makeRecently(int key) {
        int value = linkedHashMap.get(key);
        linkedHashMap.remove(key);
        linkedHashMap.put(key, value);
    }
}
