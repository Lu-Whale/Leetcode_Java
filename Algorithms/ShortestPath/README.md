# Shortest Path Algorithm

## Dijkstra
- Purpose: Finds the shortest paths from a single source vertex to all other vertices in a graph with non-negative edge weights.
- Mechanism: It uses a greedy approach, selecting the vertex with the minimum distance from the source vertex and updating the distances of its adjacent vertices.
- Complexity: With a priority queue, its time complexity can be reduced to O(VlogV + E) where V is the number of vertices and E is the number of edges.
- Limitation: Cannot handle graphs with negative edge weights.

## Bellman-Ford
- Purpose: Computes the shortest paths from a single source vertex to all other vertices in a graph, which may include negative edge weights.
- Mechanism: It relaxes all the edges V − 1 times (where V is the number of vertices) and checks for negative weight cycles in the graph. If a shorter path is found, it updates the path length.
- Complexity: Its time complexity is O(V ⋅ E), making it slower than Dijkstra's for graphs without negative weights.
- Advantages: Capable of handling graphs with negative edge weights and detecting negative cycles in the graph.

## Floyd-Warshall
- Purpose: Finds the shortest paths between all pairs of vertices in a weighted graph, which can have positive or negative edge weights but no negative cycles.
- Mechanism: It is a dynamic programming algorithm that incrementally considers all paths between every pair of vertices through an intermediate vertex.
- Complexity: Its time complexity is O(V^3) where V is the number of vertices.
- Advantages: Very straightforward and easy to implement. Suitable for computing the shortest paths between all pairs of vertices within dense graphs or when multiple queries of the shortest path are needed.