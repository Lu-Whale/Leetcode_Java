package Daily_Question;

import java.util.Arrays;

public class _1051_Height_Checker {
    public int heightChecker(int[] heights) {
        int res = 0, n = heights.length;
        int[] expected = Arrays.copyOf(heights, n);
        Arrays.sort(expected);
        for(int i = 0; i < heights.length; i++) {
            if(expected[i] != heights[i]) res++;
        }

        return res;
    }
}
