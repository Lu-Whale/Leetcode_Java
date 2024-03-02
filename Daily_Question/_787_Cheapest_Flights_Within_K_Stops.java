package Daily_Question;

import java.util.*;

public class _787_Cheapest_Flights_Within_K_Stops {

    int res = -1;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, HashMap<Integer, Integer>> adjacency = new HashMap<>();
        for(int i = 0; i < n; i++) {
            adjacency.put(i, new HashMap<>());
        }
        for(int[] flight : flights) {
            adjacency.get(flight[0]).put(flight[1], flight[2]);
        }
        boolean[] visited = new boolean[n];
        dfs(0, visited, src, dst, k, adjacency);

        return res;
    }

    public void dfs(int cost, boolean[] visited, int cur, int dst, int k, HashMap<Integer, HashMap<Integer, Integer>> adjacency) {
        if(k < 0 && cur != dst || (res != -1 && cost >= res)) return;

        if(cur == dst) {
            res = cost;
            return;
        }

        for(Map.Entry<Integer, Integer> flight : adjacency.get(cur).entrySet()) {
            int city = flight.getKey();
            int price = flight.getValue();

            cost += price;
            visited[city] = true;
            k--;

            dfs(cost, visited, city, dst, k, adjacency);

            cost -= price;
            visited[city] = false;
            k++;
        }
    }

    public static void main(String[] args) {
        _787_Cheapest_Flights_Within_K_Stops a = new _787_Cheapest_Flights_Within_K_Stops();

        int n = 4;
        int[][] flights = {{0,1,100}, {1,2,100}, {0,2,100}, {1,3,600}, {2,3,200}};
        int src = 0;
        int dst = 3;
        int k = 1;

        System.out.println(a.findCheapestPrice(n, flights, src, dst, k));
    }
}
class Solution_787_Dijkstra {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Build the graph
        int[][] mat = new int[n][n];
        for (int[] flight : flights) {
            mat[flight[0]][flight[1]] = flight[2];
        }

        // min heap: {(vertex, cost, stops), ...}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);

        // costs[i]: min cost from src to vertex 'i'
        // stops[i]: number of stops of the corresponding cheapest cost for vertex i
        int[] costs = new int[n];
        int[] stops = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);

        // Dijkstra Algorithm within k
        minHeap.offer(new int[] {src, 0, k});
        while (!minHeap.isEmpty()) {
            int[] elem = minHeap.poll();
            int vertex = elem[0], cost = elem[1], stop = elem[2];

            if (vertex == dst) {
                return cost;
            } else if (stop < 0) {
                continue;
            }

            for (int i = 0; i < n; ++i) {
                if (mat[vertex][i] > 0) {
                    int costI = costs[i], costVI = mat[vertex][i];
                    if (cost + costVI < costI) {
                        minHeap.offer(new int[] {i, costVI + cost, stop - 1});
                        costs[i] = costVI + cost;
                        stops[i] = stop - 1;
                    } else if (stops[i] < stop - 1) {
                        minHeap.offer(new int[] {i, costVI + cost, stop - 1});
                    }
                }
            }
        }
        return -1;
    }
}

// track the path
class Solution_787_Dijkstra_withPathTracking {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // 构建图
        int[][] graph = new int[n][n];
        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }

        // 优先队列
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{src, 0, K + 1});

        // 成本数组和前驱顶点数组
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        int[] prev = new int[n];
        Arrays.fill(prev, -1);

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int vertex = current[0], price = current[1], stops = current[2];

            if (vertex == dst) {
                // 重建路径
                List<Integer> path = new ArrayList<>();
                for (int at = dst; at != -1; at = prev[at]) {
                    path.add(at);
                }
                Collections.reverse(path);
                System.out.println("Path: " + path);
                return price;
            }
            if (stops > 0) {
                for (int nextVertex = 0; nextVertex < n; ++nextVertex) {
                    if (graph[vertex][nextVertex] > 0) {
                        int nextPrice = price + graph[vertex][nextVertex];
                        if (nextPrice < cost[nextVertex]) {
                            pq.offer(new int[]{nextVertex, nextPrice, stops - 1});
                            cost[nextVertex] = nextPrice;
                            prev[nextVertex] = vertex; // 更新前驱顶点
                        }
                    }
                }
            }
        }

        return -1;
    }
}

class Solution_787_Ford {
    int N = 110, INF = Integer.MAX_VALUE;
    int[][] g = new int[N][N];
    int[] dist = new int[N];
    int n, m, s, t, k;
    public int findCheapestPrice(int _n, int[][] flights, int _src, int _dst, int _k) {
        n = _n; s = _src; t = _dst; k = _k + 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                g[i][j] = i == j ? 0 : INF;
            }
        }
        for (int[] f : flights) {
            g[f[0]][f[1]] = f[2];
        }
        int ans = Bellman_Ford();
        return ans > INF / 2 ? -1 : ans;
    }
    public int Bellman_Ford() {
        Arrays.fill(dist, INF);
        dist[s] = 0;
        for (int limit = 0; limit < k; limit++) {
            int[] clone = dist.clone();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[j] = Math.min(dist[j], clone[i] + g[i][j]);
                }
            }
        }
        return dist[t];
    }
}