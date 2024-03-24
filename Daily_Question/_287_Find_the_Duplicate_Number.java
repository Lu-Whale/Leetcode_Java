package Daily_Question;

public class _287_Find_the_Duplicate_Number {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            int ind = Math.abs(nums[i]);
            if(nums[ind] < 0) {
                for(int j = 0; j < nums.length; j++) {
                    nums[j] = Math.abs(nums[j]);
                }
                return ind;
            }
            nums[ind] = -nums[ind];
        }
        return -1;
    }
}

class Solution_287 {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int pre1 = 0;
        int pre2 = slow;
        while(pre1 != pre2){
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }
}