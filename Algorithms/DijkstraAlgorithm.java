package Algorithms;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    // 定义一个类来表示顶点和它的最短距离
    class Vertex implements Comparable<Vertex> {
        public int id;
        public int distance;

        public Vertex(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }

        @Override
        public int compareTo(Vertex other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public void dijkstra(int[][] graph, int src) {
        int V = graph.length;
        int[] dist = new int[V]; // 存储最短路径的数组

        // 使用优先队列优化
        PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();

        // 初始化距离数组和优先队列
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new Vertex(src, 0));

        while (!pq.isEmpty()) {
            // 移除并返回最小距离顶点
            Vertex currentVertex = pq.poll();

            int u = currentVertex.id;

            // 遍历所有的邻接顶点
            for (int v = 0; v < V; v++) {
                // 如果找到更短的路径，则更新
                if (graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    pq.add(new Vertex(v, dist[v]));
                }
            }
        }

        // 打印最短路径结果
        printSolution(dist);
    }

    // 打印结果的方法
    public void printSolution(int[] dist) {
        System.out.println("Vertex\t\t Distance from Source");
        for (int i = 0; i < dist.length; i++)
            System.out.println(i + "\t\t " + dist[i]);
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        DijkstraAlgorithm t = new DijkstraAlgorithm();
        t.dijkstra(graph, 0);
    }
}
