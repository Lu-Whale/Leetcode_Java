package Daily_Question;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class _506_Relative_Ranks {
    class Pair {
        int index;
        int score;

        Pair(int index, int score) {
            this.index = index;
            this.score = score;
        }
    }

    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] res = new String[n];

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            hashMap.put(score[i], i);
        }
        Arrays.sort(score);
        for(int i = 0; i < n; i++) {
            if(i == n-1) {
                res[hashMap.get(score[i])] = "Gold Medal";
            }else if(i == n-2) {
                res[hashMap.get(score[i])] = "Silver Medal";
            }else if(i == n-3) {
                res[hashMap.get(score[i])] = "Bronze Medal";
            }else {
                res[hashMap.get(score[i])] = Integer.toString(n - i);
            }
        }

        return res;
    }

}
