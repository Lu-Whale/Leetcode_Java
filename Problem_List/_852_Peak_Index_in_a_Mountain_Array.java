package Problem_List;

public class _852_Peak_Index_in_a_Mountain_Array {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if(mid == 0) {
                return 1;
            }
            if(mid == n -1) {
                return n-2;
            }

            if(arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            }else if(arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            }else {
                return mid;
            }
        }

        return -1;
    }

    // Optimized version
    public int peakIndexInMountainArray2(int[] arr) {
        int n = arr.length;

        int left = 1;
        int right = n - 2;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if(arr[mid] > arr[mid + 1]) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }

        return left;
    }
}
