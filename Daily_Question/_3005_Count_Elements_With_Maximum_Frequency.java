package Daily_Question;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class _3005_Count_Elements_With_Maximum_Frequency {
    public int maxFrequencyElements(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int maxFrequency = 1;
        for(int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
            maxFrequency = Math.max(hashMap.get(num), maxFrequency);
        }

        for(int num : hashMap.keySet()) {
            if(hashMap.get(num) == maxFrequency) {
                res += maxFrequency;
            }
        }
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);

        for(int e : hashSet) {
            System.out.println(e);
        }
        return res;
    }
}
