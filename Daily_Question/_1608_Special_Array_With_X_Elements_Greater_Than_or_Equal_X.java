package Daily_Question;

import java.util.Arrays;

public class _1608_Special_Array_With_X_Elements_Greater_Than_or_Equal_X {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length; i++) {
            if(i > nums[nums.length - 1]) break;
            if(i == binarySearch(nums, i)) return i;
        }
        return -1;
    }

    public int binarySearch(int[] nums, int k) {
        int n = nums.length, left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < k) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return n - left;
    }
}

class Solution_1608 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        for (int i = 1; i <= n; ++i) {
            if (nums[i - 1] >= i && (i == n || nums[i] < i)) {
                return i;
            }
        }
        return -1;
    }
}
