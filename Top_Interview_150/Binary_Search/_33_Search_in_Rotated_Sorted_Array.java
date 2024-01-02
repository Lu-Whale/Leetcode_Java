package Top_Interview_150.Binary_Search;

public class _33_Search_in_Rotated_Sorted_Array {
    public static int search(int[] nums, int target) {
        int first = nums[0];
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        if(first > nums[n-1]) {
            while (left < right) {
                int mid = left + (right-left)/2;

                if(nums[mid] >= first) {
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }

            int index = left;

            if(target >= first) {
                left = 0;
                right = index - 1;
            }else {
                right = n - 1;
            }
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] < target) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3};
        int target = 3;

        System.out.println(search(nums, target));
    }
}
