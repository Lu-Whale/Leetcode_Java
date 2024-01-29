package Top_Interview_150.Array_String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _42_Trapping_Rain_Water {
    public int trap(int[] height) {
        int n = height.length;

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for(int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int res = 0;
        for(int i = 0; i < n; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return res;
    }

    public int trapWithTwoPointer(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if(height[left] < height[right]) {
                res += leftMax - height[left];
                left++;
            }else {
                res += rightMax - height[right];
                right--;
            }
        }

        return res;
    }


    public int trapWrongAnswer(int[] height) {
        int res = 0;
        int n = height.length;
        List<int[]> peaks = new ArrayList<>();
        for(int i = 1; i < n - 1; i++) {
            if(height[i-1] <= height[i] && height[i+1] <= height[i]) {
                peaks.add(new int[]{i, height[i]});
            }
        }
        peaks.add(new int[]{n-1, height[n-1]});

        int[] left = new int[]{0, height[0]};
        for(int[] right : peaks) {
            if(right[0] - left[0] <= 1){
                left = right;
                continue;
            }
            int minPeak = Math.min(left[1], right[1]);
            int water = (right[0] - left[0] - 1) * minPeak;
            for(int i = left[0] + 1; i < right[0]; i++){
                water -= Math.min(height[i], minPeak);
            }
            left = right;
            res += water;
        }

        return res;
    }




}
