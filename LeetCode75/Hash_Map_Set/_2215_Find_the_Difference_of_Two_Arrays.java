package LeetCode75.Hash_Map_Set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//https://leetcode.com/problems/find-the-difference-of-two-arrays/?envType=study-plan-v2&envId=leetcode-75
public class _2215_Find_the_Difference_of_Two_Arrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(checkSame(nums1, nums2));
        result.add(checkSame(nums2, nums1));

        return result;
    }

    public List<Integer> checkSame(int[] PrimaryNums, int[] ReferenceNums) {
        List<Integer> list = new ArrayList<>();

        for (int primaryNum : PrimaryNums) {
            if (list.contains(primaryNum)) continue;

            boolean exist = false;
            for (int referenceNum : ReferenceNums) {
                if (primaryNum == referenceNum) {
                    exist = true;
                    break;
                }
            }

            if (!exist) {
                list.add(primaryNum);
            }
        }
        return list;
    }

    // O(n) time
    public List<List<Integer>> findDifference2(int[] nums1, int[] nums2) {
        //Approach: Using HashSet
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> lis1 = new ArrayList<>();
        List<Integer> lis2 = new ArrayList<>();

        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();

        //traverse and add to set's
        for(int n:nums1){
            s1.add(n);
        }
        for(int n:nums2){
            s2.add(n);
        }

        //traverse and check
        for(int n:s1){
            if(!s2.contains(n)){
                lis1.add(n);
            }
        }
        for(int n:s2){
            if(!s1.contains(n)){
                lis2.add(n);
            }
        }

        //add to ans
        ans.add(lis1);
        ans.add(lis2);

        return ans;
    }
}
