package Contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _3085_Minimum_Deletions_to_Make_String_K_Special {
    public static int minimumDeletions(String word, int k) {
        int res = Integer.MAX_VALUE;

        int n = word.length();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            char c = word.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        int[] chars = new int[hashMap.size()];
        int index = 0;
        for(int num : hashMap.values()) {
            chars[index++] = num;
        }
        Arrays.sort(chars);
        System.out.println(Arrays.toString(chars));

        int preCount = 0;
        for(int i = 0; i < chars.length; i++) {
            if (i == 0 || chars[i] != chars[i - 1]) {
                int tmp = preCount;
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[j] > chars[i] + k) tmp += (chars[j] - (k + chars[i]));
                }
                res = Math.min(tmp, res);
            }
            preCount += chars[i];
        }

        return res;
    }

    public static void main(String[] args) {
        String word = "gzpgogrg";
        int k = 1;
        minimumDeletions(word, k);
    }
}
