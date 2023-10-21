package LeetCode75.Two_Pointer;


// Given an integer array nums, move all 0's to the end of it while maintaining the relative
// order of the non-zero elements.
//
//Note that you must do this in-place without making a copy of the array.
//Example 1:
//
//Input: nums = [0,1,0,3,12]
//Output: [1,3,12,0,0]
//Example 2:
//
//Input: nums = [0]
//Output: [0]
public class Move_Zeroes_283 {
    public void moveZeroes(int[] nums) {
        int p = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[p] = nums[i];
                p++;
            }
        }

        for(int i = p; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}

//1. Initialize a variable i to 0. This variable will be used to keep track of the index where the next non-zero element should be placed.
//
//2. Start a loop that iterates over each element num in the nums array.
//
//3. Check if the current element num is not equal to 0 (which means it's a non-zero element).
//
//4. If the current element is non-zero, assign it to the position nums[i] in the array, and then increment i by 1. This moves the non-zero element to the left side of the array.
//
//5. After processing all the elements in the array, there might be some remaining positions towards the end of the array that need to be filled with zeros.
//
//6. Start another loop that continues from the last value of i until the end of the array (nums.length).
//
//7. Set the value of nums[i] to 0, effectively placing zeros in the remaining positions at the end of the array.
//
//8. Increment i by 1 in each iteration to move to the next position in the array.
//
//9. Once this loop is completed, all the non-zero elements have been moved to the front of the array, and any remaining positions towards the end of the array have been filled with zeros.
