package Daily_Question;

public class _713_Subarray_Product_Less_Than_K {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0, l = 0, r = 0, mul = 1;

        if(k == 0) return res;

        // j-i+1是以右端点元素为末尾元素的子数组的个数(区间多长，含末尾元素的子数组就有多少个)，
        // 所有元素做队尾的子数组数之和就是符合条件子数组的个数。
        // 比如例子[10,5,2,6]以10做队尾的子数组[10],以5做队尾的子数组[10,5],[5]，以2作队尾 [5,2],[2],以此类推。
        while (r < nums.length) {
            mul *= nums[r];
            while (mul >= k && l <= r) {
                mul /= nums[l];
                l++;
            }
            res += r - l + 1;
            r++;
        }

        return res;
    }
}
