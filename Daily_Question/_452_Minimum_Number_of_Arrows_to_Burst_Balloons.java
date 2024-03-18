package Daily_Question;

import java.util.Arrays;
import java.util.Comparator;

public class _452_Minimum_Number_of_Arrows_to_Burst_Balloons {
    public static int findMinArrowShots(int[][] points) {
        int res = 1;
        // Comparator.comparingInt(a -> a[0]) can solve the problem of integer overflow
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int right = points[0][1];
        for (int[] point : points) {
            if (point[0] > right) {
                res++;
                right = point[1];
            } else {
                right = Math.min(right, point[1]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] points = {{-2147483646,-2147483645}, {2147483646,2147483647}};

        System.out.println(findMinArrowShots(points));
    }
}
