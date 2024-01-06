package Problem_List;

public class _34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        int[] res = new int[2];
        int left = 0;
        int right = n-1;

        //find left boundary
        int leftIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
            if(nums[mid] == target) {
               leftIndex = mid;
            }
        }

        left = 0;
        right = n - 1;

        // find right boundary
        int rightIndex = -1;
        while (left <= right) {
            int mid = left + (right -left) / 2;
            if(nums[mid] <= target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
            if(nums[mid] == target) {
                rightIndex = mid;
            }
        }

        res[0] = leftIndex;
        res[1] = rightIndex;

        return res;
    }
}
