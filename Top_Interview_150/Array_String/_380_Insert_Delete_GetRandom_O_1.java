package Top_Interview_150.Array_String;

import java.util.*;

public class _380_Insert_Delete_GetRandom_O_1 {
}

class RandomizedSet {
    HashMap<Integer, Integer> hashMap;
    List<Integer> list;
    Random random;

    public RandomizedSet() {
        hashMap = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(hashMap.containsKey(val)) {
            return false;
        }
        hashMap.put(val, list.isEmpty() ? 0 : list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(hashMap.containsKey(val)) {
            int index = hashMap.get(val);
            int lastVal = list.get(list.size() - 1);
            list.set(index, lastVal);
            list.remove(list.size() - 1);
            hashMap.put(lastVal, index);
            hashMap.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
