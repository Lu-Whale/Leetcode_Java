package Daily_Question;


import java.util.HashMap;

// 3.30 not ac
public class _992_Subarrays_with_K_Different_Integers {
    public static int subarraysWithKDistinct(int[] nums, int k) {
        int res = 0;
        //key is num, value is the last appearance index of num
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int left = 0;
        for(int right = 0; right < nums.length; right++) {
            int num = nums[right];

            if(hashMap.containsKey(num) && hashMap.size() == k) {
                if(num == nums[left]) {
                    res += (hashMap.get(nums[left]) - left + 2);
                }else {
                    res += (hashMap.get(nums[left]) - left + 1);
                }
                hashMap.put(num, right);
            }

            if(!hashMap.containsKey(num)) {

                if(hashMap.size() == k) {
                    while (hashMap.size() == k) {
                        if(left == hashMap.get(nums[left])) hashMap.remove(nums[left]);
                        left++;
                    }
                     res += (hashMap.get(nums[left]) - left + 1);
                }
            }
            System.out.println(res);
            hashMap.put(num, right);
        }

        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {1,2,1,3,2,2,1,4};
        int[] nums = {1,2,1,2,3};
        subarraysWithKDistinct(nums, 2);
//        System.out.println(subarraysWithKDistinct(nums, 3));

    }
}

public class Solution {

    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostKDistinct(A, K) - atMostKDistinct(A, K - 1);
    }

    /**
     * @param A
     * @param K
     * @return 最多包含 K 个不同整数的子区间的个数
     */
    private int atMostKDistinct(int[] A, int K) {
        int len = A.length;
        int[] freq = new int[len + 1];

        int left = 0;
        int right = 0;
        // [left, right) 里不同整数的个数
        int count = 0;
        int res = 0;
        // [left, right) 包含不同整数的个数小于等于 K
        while (right < len) {
            if (freq[A[right]] == 0) {
                count++;
            }
            freq[A[right]]++;
            right++;

            while (count > K) {
                freq[A[left]]--;
                if (freq[A[left]] == 0) {
                    count--;
                }
                left++;
            }
            // [left, right) 区间的长度就是对结果的贡献
            res += right - left;
        }
        return res;
    }
}