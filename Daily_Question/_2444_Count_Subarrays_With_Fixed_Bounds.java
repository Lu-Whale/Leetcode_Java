package Daily_Question;

import java.util.stream.StreamSupport;

//3.31
public class _2444_Count_Subarrays_With_Fixed_Bounds {
    public static long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0L;

        boolean existMin = false, existMax = false;
        int indexMin = -1, indexMax = -1;
        int left = 0;
        for(int right = 0; right < nums.length; right++) {
            int numR = nums[right];
            if(numR < minK || numR > maxK) {
                left = right + 1;
                indexMin = -1;
                indexMax = -1;
                existMin = false;
                existMax = false;
            }else {
                if(numR == minK) {
                    existMin = true;
                    indexMin = right;
                }
                if(numR == maxK) {
                    existMax = true;
                    indexMax = right;
                }

                if(existMin && existMax) {
                    res += (Math.min(indexMin, indexMax) - left + 1);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {934372,927845,479424,49441,17167,17167,65553,927845,17167,927845,17167,425106,17167,927845,17167,927845,251338,17167};
        int minK = 17167;
        int maxK = 927845;

        countSubarrays(nums, minK, maxK);
    }
}
