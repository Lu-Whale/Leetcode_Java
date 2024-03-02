package Algorithms.ShortestPath;

// Shortest path from one node to all nodes, negative edges allowed
// https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/
public class Bellman_Ford {
    public int[] BellmanFord(Graph graph, int src) {
        int V = graph.V, E = graph.E;
        int[] dist = new int[V];

        // Step 1: Initialize distances from src to all other vertices as INFINITE
        for (int i = 0; i < V; ++i)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;

        // Step 2: Relax all edges |V| - 1 times.
        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                int weight = graph.edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        // Step 3: Check for negative-weight cycles.
        for (int j = 0; j < E; ++j) {
            int u = graph.edge[j].src;
            int v = graph.edge[j].dest;
            int weight = graph.edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return null;
            }
        }

        // Print the calculated shortest distances
        return dist;
    }
}
class Edge {
    int src, dest, weight;
    Edge() {
        src = dest = weight = 0;
    }
}

class Graph {
    int V, E;
    Edge[] edge;

    Graph(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }
}
