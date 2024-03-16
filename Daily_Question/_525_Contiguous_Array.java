package Daily_Question;

import java.util.HashMap;

public class _525_Contiguous_Array {
    public int findMaxLength(int[] nums) {
        int res = 0;

        int sum = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(sum, -1);
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num == 1) sum++;
            if(num == 0) sum--;

            if(hashMap.containsKey(sum)) {
                res = Math.max(res, (i - hashMap.get(sum)));
            }else {
                hashMap.put(sum, i);
            }
        }

        return res;
    }
}
