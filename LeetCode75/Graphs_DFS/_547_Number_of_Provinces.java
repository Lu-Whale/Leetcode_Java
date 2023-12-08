package LeetCode75.Graphs_DFS;

public class _547_Number_of_Provinces {
    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        boolean[] visited = new boolean[cities];
        int provinces = 0;
        for(int i = 0; i < cities; i++) {
            if(!visited[i]) {
                dfs(isConnected, visited, i);
                provinces++;
            }
        }
        return provinces;
    }

    public void dfs(int[][] isConnected, boolean[] visited, int i) {
        visited[i] = true;

        for(int j = 0; j < isConnected.length; j++) {
            if(isConnected[i][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j);
            }
        }
    }
}
