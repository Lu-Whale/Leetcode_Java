package Daily_Question;

import java.util.HashSet;

public class _349_Intersection_of_Two_Arrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> nums2HashSet = new HashSet<>();
        for(int num : nums2) {
            nums2HashSet.add(num);
        }

        HashSet<Integer> resHashSet = new HashSet<>();
        for(int num : nums1) {
            if(nums2HashSet.contains(num)) resHashSet.add(num);
        }
        int[] res = new int[resHashSet.size()];
        int i = 0;
        for(int num : resHashSet) {
            res[i++] = num;
        }
        return res;
    }
}
