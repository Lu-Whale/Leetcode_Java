package Daily_Question;

import java.util.*;

public class _846_Hand_of_Straights {
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;

        Arrays.sort(hand);
        List<List<Integer>> groups = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            boolean rearrange = false;
            for(int j = 0; j < groups.size(); j++) {
                List<Integer> group = groups.get(j);

                if(group.size() < groupSize && group.get(group.size() - 1) == hand[i] - 1){
                    group.add(hand[i]);
                    rearrange = true;
                    break;
                }
            }
            if(!rearrange) {
                List<Integer> group = new ArrayList<>();
                group.add(hand[i]);
                groups.add(group);
                rearrange = true;
            }

            if(!rearrange) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;

        isNStraightHand(hand,groupSize);
    }
}

class Solution_846 {
    public boolean isNStraightHand(int[] hand, int m) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b)->a-b);
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            q.add(i);
        }
        while (!q.isEmpty()) {
            int t = q.poll();
            if (map.get(t) == 0) continue;
            for (int i = 0; i < m; i++) {
                int cnt = map.getOrDefault(t + i, 0);
                if (cnt == 0) return false;
                map.put(t + i, cnt - 1);
            }
        }
        return true;
    }
}
