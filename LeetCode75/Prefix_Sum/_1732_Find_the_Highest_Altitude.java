package LeetCode75.Prefix_Sum;

//https://leetcode.com/problems/find-the-highest-altitude/?envType=study-plan-v2&envId=leetcode-75
public class _1732_Find_the_Highest_Altitude {
    public int largestAltitude(int[] gain) {

        int currentAltitude = 0;
        int result = 0;

        for(int i = 0; i < gain.length; i++) {
            currentAltitude = currentAltitude + gain[i];
            result = Math.max(result, currentAltitude);
        }

        return result;
    }
}
