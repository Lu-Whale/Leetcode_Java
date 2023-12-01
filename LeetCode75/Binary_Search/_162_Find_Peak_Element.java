package LeetCode75.Binary_Search;

// https://leetcode.com/problems/find-peak-element/?envType=study-plan-v2&envId=leetcode-75
public class _162_Find_Peak_Element {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        int leftPointer = 0;
        int rightPointer = n-1;
        // if nums contains 1 element, left pointer is same as right pointer, then the while loop won't be executed
        while (leftPointer < rightPointer) {
            // Due to integer division, mid will be biased towards the left side
            int mid = (leftPointer + rightPointer) / 2;
            if(nums[mid] > nums[mid+1]) {
                rightPointer = mid;
            }else {
                // *****
                leftPointer = mid + 1;
            }
        }
        //after iteration, the left pointer is same as right pointer, so we can return either of them.
        return rightPointer;
    }
}
