package Daily_Question;

import java.util.*;

//2.24
public class _2092_Find_All_People_With_Secret {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        HashSet<Integer> PeopleKnowsTheSecret = new HashSet<>();
        PeopleKnowsTheSecret.add(0);
        PeopleKnowsTheSecret.add(firstPerson);

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for(int[] meeting : meetings) {
            priorityQueue.offer(meeting);
        }

        while (!priorityQueue.isEmpty()) {
            int curTime = priorityQueue.peek()[2];
            // The adjacency of the graph at the time curTime
            HashMap<Integer, List<Integer>> adjacency = new HashMap<>();
            // Used to check whether the person i is visited in DFS
            HashMap<Integer, Boolean> visited = new HashMap<>();
            // Used store the person who already knows the secret currently and are holding the meeting
            List<Integer> personList = new ArrayList<>();

            while (!priorityQueue.isEmpty() && priorityQueue.peek()[2] == curTime) {
                int[] meeting = priorityQueue.poll();

                adjacency.putIfAbsent(meeting[0], new ArrayList<>());
                adjacency.putIfAbsent(meeting[1], new ArrayList<>());

                adjacency.get(meeting[0]).add(meeting[1]);
                adjacency.get(meeting[1]).add(meeting[0]);

                visited.put(meeting[0], false);
                visited.put(meeting[1], false);

                if(PeopleKnowsTheSecret.contains(meeting[0])) personList.add(meeting[0]);
                if(PeopleKnowsTheSecret.contains(meeting[1])) personList.add(meeting[1]);
            }

            for(int u : personList) {
                dfs(u, visited, PeopleKnowsTheSecret, adjacency);
            }
        }

        return new ArrayList<>(PeopleKnowsTheSecret);
    }

    public void dfs(int u, HashMap<Integer, Boolean> visited, HashSet<Integer> PeopleKnowsTheSecret, HashMap<Integer, List<Integer>> adjacency) {
        if(visited.get(u)) {
            return;
        }

        visited.put(u, true);
        PeopleKnowsTheSecret.add(u);

        for(int v : adjacency.get(u)) {
            dfs(v, visited, PeopleKnowsTheSecret, adjacency);
        }
    }
}

class Solution_2092 {

    // 并查集数组，记录每个元素的祖先节点
    public int[] p;

    // 查找每个元素的祖先，（路径压缩，并查集模板）
    public int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        p = new int[n+1];
        // 祖先数组初始化，将每个元素的祖先标记为自己
        for (int i = 1; i <= n; ++ i) p[i] = i;
        // 合并0号专家与firstPerson
        p[firstPerson] = 0;
        Map<Integer, List<int[]>> map = new TreeMap<>();
        // 构造以时刻为key，会议列表为value的Map，TreeMap将自动按照key升序排序
        for (int[] m : meetings) {
            // m[2]为会议时刻，每个时刻对应多场会议
            List<int[]> list = map.getOrDefault(m[2], new ArrayList<>());
            list.add(m);
            map.put(m[2], list);
        }
        // 对于每个时刻，遍历两次
        for (int x : map.keySet()) {
            // 第一轮遍历，合并集合
            for (int[] l : map.get(x)) {
                int a = l[0], b = l[1];
                if (p[find(a)] == 0 || p[find(b)] == 0) { p[find(a)] = 0; p[find(b)] = 0; }
                p[find(b)] = p[find(a)];
            }
            // 第二轮遍历，分场景讨论
            for (int[] l : map.get(x)) {
                int a = l[0], b = l[1];
                // 场景一：两位专家在前面的会议均不知道秘密，后面遍历中其中一位专家知道了秘密，瞬时共享，两人都将知道秘密
                if (p[find(a)] == 0 || p[find(b)] == 0) { p[find(a)] = 0; p[find(b)] = 0; }
                // 场景二：两位专家在该时刻始终都不知道秘密，将合并的集合分离开，防止后面时刻有一个专家知道秘密，将秘密分享给另一个专家
                else { p[a] = a; p[b] = b; }
            }
        }
        List<Integer> ans = new ArrayList<>();
        // 祖先为0的元素即为知道秘密的专家
        for (int i = 0; i < n; ++ i) {
            if (p[find(i)] == 0) ans.add(i);
        }
        return ans;
    }
}
