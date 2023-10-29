package LeetCode75.Hash_Map_Set;

//https://leetcode.com/problems/unique-number-of-occurrences/?envType=study-plan-v2&envId=leetcode-75

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class _1207_Unique_Number_of_Occurrences {
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> occurrences = new HashMap<>();
        boolean result = true;
        for(int i = 0; i < arr.length; i++) {
            if(occurrences.containsKey(arr[i])) {
                occurrences.put(arr[i], occurrences.get(arr[i]) + 1);
            }else {
                occurrences.put(arr[i], 1);
            }
        }

        HashSet<Integer> checkUnique = new HashSet<>();
        for(int key : occurrences.keySet()) {
            if(checkUnique.contains(occurrences.get(key))) {
                result = false;
                break;
            }else {
                checkUnique.add(occurrences.get(key));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 3};

        System.out.println(uniqueOccurrences(arr));
    }
}
