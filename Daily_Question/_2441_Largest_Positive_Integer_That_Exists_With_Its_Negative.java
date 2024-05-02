package Daily_Question;

import java.util.HashSet;

public class _2441_Largest_Positive_Integer_That_Exists_With_Its_Negative {
    public int findMaxK(int[] nums) {
        int res = -1;

        HashSet<Integer> hashSet = new HashSet<>();
        for(int num : nums) {
            if(hashSet.contains(-num)) {
                res = Math.max(Math.abs(num), res);
            }else {
                hashSet.add(num);
            }
        }

        return res;
    }
}
