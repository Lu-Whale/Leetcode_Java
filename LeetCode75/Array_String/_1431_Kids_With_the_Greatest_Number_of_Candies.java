package LeetCode75.Array_String;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/?envType=study-plan-v2&envId=leetcode-75
public class _1431_Kids_With_the_Greatest_Number_of_Candies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = 0;
        for(int candy: candies) {
            max = Math.max(candy, max);
        }

        for(int candy: candies) {
            result.add(candy + extraCandies >= max);
        }

        return result;
    }
}
