package Daily_Question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

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
class Solution {
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