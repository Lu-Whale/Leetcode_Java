package Daily_Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 2.22 2024
public class _997_Find_the_Town_Judge {
    public int findJudge(int n, int[][] trust) {
        HashMap<Integer, List<Integer>> adjacency = new HashMap<>();
        int[] inDegrees = new int[n+1];
        for(int i = 1; i <= n; i++) {
            adjacency.put(i, new ArrayList<>());
        }
        for(int[] pair : trust) {
            adjacency.getOrDefault(pair[1], new ArrayList<>()).add(pair[0]);
            inDegrees[pair[0]]++;
        }

        for(int i = 1; i <= n; i++) {
            if(adjacency.get(i).size() == n-1 && inDegrees[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}

class Solution_997 {
    public int findJudge(int n, int[][] trust) {
        int[] trusting = new int[n + 1];
        int[] trusted = new int[n + 1];

        for (int i = 0; i < trust.length; i++) {
            trusting[trust[i][0]]++;
            trusted[trust[i][1]]++;
        }

        int ans = -1;

        for (int i = 1; i <= n; i++) {
            if (trusting[i] == 0 && trusted[i] == n - 1)
                ans = i;
        }

        return ans;
    }
}
