package LeetCode75.Binary_Search;

import java.util.Arrays;

public class _2300_Successful_Pairs_of_Spells_and_Potions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];

        Arrays.sort(potions);
        for(int i = 0; i < n; i++) {

            int left = 0;
            int right = m - 1;

            while (left <= right) {
                int mid = (right + left) / 2;

                if((long) spells[i] * potions[mid] >= success) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }

            result[i] = m - left;
        }

        return result;
    }
}
