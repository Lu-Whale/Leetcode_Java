package LeetCode75.Sliding_Window;

import java.util.LinkedList;
import java.util.Queue;

public class _1004_Max_Consecutive_Ones_III {
    public static int longestOnes(int[] nums, int k) {

        int result = 0;
        int left = 0;
        int right;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                right = i;

            }else {
                if(k > 0) {
                    k--;
                    right = i;
                }else {
                    while (nums[left] != 0) {
                        left++;
                    }
                    left++;
                    right = i;
                }
            }
            result = Math.max(right - left + 1, result);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

//        longestOnes(nums, k);
        System.out.println(longestOnes(nums,k));
    }
}
