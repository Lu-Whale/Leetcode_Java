package Top_Interview_150.Array_String;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150
public class _80_Remove_Duplicates_from_Sorted_Array_II {
    public int removeDuplicates(int[] nums) {
        int pointer = 1;
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            count = nums[i] == nums[i-1] ? count + 1 : 1;

            if(count <= 2) {
                nums[pointer] = nums[i];
                pointer++;
            }

        }

        return pointer;
    }
}
