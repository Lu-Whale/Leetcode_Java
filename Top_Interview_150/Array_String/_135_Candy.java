package Top_Interview_150.Array_String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _135_Candy {
    public static int candy(int[] ratings) {
        int[] newRatings = new int[ratings.length + 2];
        int n = newRatings.length;
        for(int i = 0; i < n; i++) {
            if(i == 0 || i == n - 1) {
                newRatings[i] = Integer.MAX_VALUE;
            }else {
                newRatings[i] = ratings[i-1];
            }
        }

        int[] children = new int[n];
        List<Integer> bottom = new ArrayList<>();
        for(int i = 1; i < n-1; i++) {
            if(newRatings[i] <= newRatings[i-1] && newRatings[i] <= newRatings[i+1]) {
                children[i] = 1;
                bottom.add(i);
            }

        }

        for(int i : bottom) {
            int cur = i;
            //right
            while (cur + 1 < n - 1 && newRatings[cur + 1] > newRatings[cur]){
                children[cur + 1] = children[cur] + 1;
                cur++;
            }
            //left
            cur = i;
            while (cur - 1 > 0 && newRatings[cur - 1] > newRatings[cur]) {
                children[cur - 1] = Math.max(children[cur - 1], children[cur] + 1);
                cur--;
            }
        }
        System.out.println(Arrays.toString(children));

        int res = 0;
        for(int candies : children) {
            res += candies;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ratings = {1,2,3,3,1,4,3,2,1};
        candy(ratings);
    }
}
