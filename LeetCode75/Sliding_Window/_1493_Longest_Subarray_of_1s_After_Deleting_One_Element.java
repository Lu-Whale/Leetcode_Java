package LeetCode75.Sliding_Window;

// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/?envType=study-plan-v2&envId=leetcode-75
public class _1493_Longest_Subarray_of_1s_After_Deleting_One_Element {
    public static int longestSubarray(int[] nums) {
        // initial
        int result = 0;
        int left = 0;
        int right = 0;
        //check if the first element is 0 and default to delete operation
        boolean delete = nums[0] == 0;
        //sliding window
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == 0) {
                if(delete) {
                    //update left boundary
                    while (nums[left] == 1 && left != right) {
                        left++;
                    }
                    left++;

                }else {
                    delete = true;
                }
                // update right boundary
                right = i;
            }else {
                right++;
            }
            result = Math.max(result, right-left);
        }

        // since right-left already 1 smaller than the sliding window size, we don't need to minus 1 at this time

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {0,1,1,1,0,1,1,0,1};
        System.out.println(longestSubarray(nums));
    }
}
