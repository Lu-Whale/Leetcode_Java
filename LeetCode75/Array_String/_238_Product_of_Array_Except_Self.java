package LeetCode75.Array_String;

import java.util.Arrays;

// https://leetcode.com/problems/product-of-array-except-self/?envType=study-plan-v2&envId=leetcode-75
public class _238_Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);
        int tmp = 1;

        for(int i = 0; i < n; i++) {
            //current tmp is prefix of nums[i]
            result[i] *= tmp;
            //update tmp by multiple nums[i]
            tmp *= nums[i];
        }
        // after first for loop, result contains product of prefix

        //then update result by multiply the product of Suffix
        tmp = 1;
        for(int i = n-1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }

        return result;
    }
}
