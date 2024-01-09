package Top_Interview_150;

import java.util.*;

public class _373_Find_K_Pairs_with_Smallest_Sums {
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;
        List<List<Integer>> res = new ArrayList<>(k);
//        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> ((nums1[a[0]]+nums2[a[1]]) - (nums1[b[0]]) - nums2[b[1]]));
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int sum1 = nums1[o1[0]] + nums2[o1[1]];
                int sum2 = nums1[o2[0]] + nums2[o2[1]];
                return sum1 - sum2;
            }
        });

        for(int i = 0; i < Math.min(n1, k); i++) {
            priorityQueue.offer(new int[]{i, 0});
        }

        while (res.size() < k && !priorityQueue.isEmpty()) {
            int[] IndexPair = priorityQueue.poll();
            List<Integer> pair = new ArrayList<>(2);
            pair.add(nums1[IndexPair[0]]);
            pair.add(nums2[IndexPair[1]]);
            res.add(pair);

            if(IndexPair[1] + 1 < n2) {
                priorityQueue.offer(new int[]{IndexPair[0],IndexPair[1] + 1});
            }
        }

        return res;
    }



    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        System.out.println(kSmallestPairs(nums1, nums2, k));

        int[] n1 = {1, 1, 2};
        int[] n2 = {1, 2, 3};
        int k2 = 2;
        System.out.println(kSmallestPairs(n1, n2, k2));
    }
}
