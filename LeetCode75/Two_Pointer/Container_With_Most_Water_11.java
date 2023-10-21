package LeetCode75.Two_Pointer;


// You are given an integer array height of length n. There are n vertical lines drawn such
// that the two endpoints of the ith line are (i, 0) and (i, height[i]).
//
// Find two lines that together with the x-axis form a container, such that the container
// contains the most water.
//
// Return the maximum amount of water a container can store.
//
// Notice that you may not slant the container.

//Example 1:
//
//Input: height = [1,8,6,2,5,4,8,3,7]
//Output: 49
// Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
// In this case, the max area of water (blue section) the container can contain is 49.
//
//Example 2:
//
//Input: height = [1,1]
//Output: 1

public class Container_With_Most_Water_11 {
    //
    public int mySolution(int[] height) {
        int result = 0;
        int point1 = 0;
        for(int i = 0; i < height.length - 1; i++) {
            // every iteration, the weight goes smaller, so if the height is smaller than previous,
            // then the area cannot larger than previous.
            if(height[i] < height[point1]) {
                continue;
            }
            point1 = i;
            int pointer2 = height.length -1;
            for(int j = height.length - 1; j > i; j--){
                if(height[j] < height[pointer2]) {
                    continue;
                }
                pointer2 = j;
                if((j-i)*Math.min(height[j], height[i]) > result) {
                    result = (j-i)*Math.min(height[j], height[i]);
                }
            }
        }
        return result;
    }

    //
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}














