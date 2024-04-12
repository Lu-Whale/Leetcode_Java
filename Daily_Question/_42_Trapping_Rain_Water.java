package Daily_Question;

public class _42_Trapping_Rain_Water {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int leftMax = 0, rightMax = 0;
        for(int i = 0; i < n; i++) {
            left[i] = leftMax;
            right[n - i - 1] = rightMax;

            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[n - i - 1]);
        }
        int res = 0;
        for(int i = 0; i < n; i++) {
            res += Math.max(Math.min(left[i], right[i]) - height[i], 0);
        }

        return res;
    }
}

class Solution_42 {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1, sum = 0, leftBar = height[l], rightBar = height[r];

        while (l < r) {
            if (leftBar <= rightBar) {
                sum += leftBar - height[l];
                l++;
                leftBar = Math.max(leftBar, height[l]);
            } else {
                sum += rightBar - height[r];
                r--;
                rightBar = Math.max(rightBar, height[r]);
            }
        }

        return sum;
    }
}
