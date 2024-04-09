package LeetCode75.Graph_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class _1926_Nearest_Exit_from_Entrance_in_Maze {
    private static final int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0});
        maze[entrance[0]][entrance[1]] = '+';

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] position = queue.poll();
                for(int[] dir : directions) {
                    int x = position[0] + dir[0];
                    int y = position[1] + dir[1];
                    int steps = position[2] + 1;

                    if(x < 0 || x >= m || y < 0 || y >= n || maze[x][y] == '+') {
                        continue;
                    }
                    if((x == 0 || x == m-1 || y == 0 || y == n-1)) {
                        return steps;
                    }
                    maze[x][y] = '+';
                    queue.offer(new int[]{x, y, steps});
                }
            }
        }

        return -1;
    }

}

class Solution_1926_DFS_TimeLimitExceeded {
    int res = Integer.MAX_VALUE;
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        boolean[][] visited = new boolean[m][n];
        dfs(maze, entrance[0], entrance[1], visited, 0);

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public void dfs(char[][] maze, int row, int column, boolean[][] visited, int steps) {
        if(row < 0 || row >= maze.length || column < 0 || column >= maze[0].length) {
            return;
        }
        if(maze[row][column] == '+' || visited[row][column]) {
            return;
        }

        if((row == 0 || column == 0 || row == maze.length -1 || column == maze[0].length - 1) && steps != 0) {
            res = Math.min(steps, res);
            return;
        }

        visited[row][column] = true;

        dfs(maze, row + 1, column, visited, steps + 1);
        dfs(maze, row - 1, column, visited, steps + 1);
        dfs(maze, row, column + 1, visited, steps + 1);
        dfs(maze, row, column - 1, visited, steps + 1);

        visited[row][column] = false;
    }
}