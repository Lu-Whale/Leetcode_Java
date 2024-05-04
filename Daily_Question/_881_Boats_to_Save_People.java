package Daily_Question;

import java.util.Arrays;

public class _881_Boats_to_Save_People {
    public int numRescueBoats(int[] people, int limit) {
        int res = 0;

        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        while (l < r) {
            while (l < r && people[r] + people[l] > limit) {
                res++;
                r--;
            }
            res++;
            l++;
            r--;
        }
        return l == r ? res + 1 : res;
    }
}
