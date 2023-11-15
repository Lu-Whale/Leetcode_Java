package LeetCode75.Array_String;

//https://leetcode.com/problems/increasing-triplet-subsequence/?envType=study-plan-v2&envId=leetcode-75
public class _334_Increasing_Triplet_Subsequence {
    public static boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) {
            return false;
        }
        boolean result = false;
        for(int i = 0; i < nums.length - 2; i++) {
            int tmp = nums[i];
            int secTmp = -1;
            for(int j = i+1; j < nums.length; j++) {
                if((secTmp == -1 || nums[j] < secTmp)&& tmp < nums[j]) {
                    secTmp = nums[j];
                }
                if(secTmp != -1 && nums[j] > secTmp) {
                    result = true;
                    break;
                }
            }
            if(result){
                break;
            }
        }
        return result;
    }

    //find a number j which exist a number i at left of j and smaller than j, also find a number k that at right of k and larger than j
    public boolean increasingTriplet2(int[] nums) {
        int n = nums.length;
        if(n < 3) {
            return false;
        }

        int[] leftMin = new int[n];
        leftMin[0] = nums[0];
        for(int i = 1; i < n-2; i++) {
            leftMin[i] = Math.min(leftMin[i-1], nums[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], nums[i]);
        }

        for(int i = 1; i < n-1; i++) {
            if(nums[i] > leftMin[i-1] && nums[i] < rightMax[i+1]) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {1,5,0,4,1,3};

        System.out.println(increasingTriplet(nums));
    }
}
