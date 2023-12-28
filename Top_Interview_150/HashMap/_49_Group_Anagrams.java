package Top_Interview_150.HashMap;

import java.util.*;

// https://leetcode.com/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-interview-150
public class _49_Group_Anagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            char[] s = str.toCharArray();
            Arrays.sort(s);

            List<String> group = hashMap.getOrDefault(Arrays.toString(s), new ArrayList<>());
            group.add(str);
            hashMap.put(Arrays.toString(s), group);
        }

        return new ArrayList<>(hashMap.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        System.out.println(groupAnagrams(strs));

    }
}
