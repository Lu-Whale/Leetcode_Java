package LeetCode75.Binary_Search;

public class _875_Koko_Eating_Bananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int maxK = 0;
        for(int i : piles) {
            maxK = Math.max(i, maxK);
        }
        int minK = 1;

        while (minK < maxK) {
            int mid = (maxK + minK) / 2;

            int hours = 0;
            for(int i : piles) {
                hours += i % mid == 0 ? i / mid : i / mid + 1;
            }

            if(hours <= h) {
                maxK = mid;
            }else {
                minK = mid + 1;
            }
        }

        return maxK;
    }

    public static void main(String[] args) {
        int h = 8;
        int[] piles = {3,6,7,11};

        minEatingSpeed(piles, h);
    }
}
