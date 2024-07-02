package Daily_Question;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _350_Intersection_of_Two_Arrays_II {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int num : nums1) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        for(int num : nums2) {
            if(hashMap.containsKey(num) && hashMap.get(num) > 0) {
                list.add(num);
                hashMap.replace(num, hashMap.get(num) - 1);
            }
        }

        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
