package LeetCode75.Graph_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class _994_Rotting_Oranges {
    class Orange {
        int x;
        int y;
        public Orange(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static final int[][] direction = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Orange> queue = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new Orange(i,j));
                }
                if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }


        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false;
            for(int i = 0; i < size; i++) {
                Orange orange = queue.poll();
                for(int[] dir : direction) {
                    int x = orange.x + dir[0];
                    int y = orange.y + dir[1];

                    // omg exceed the boundary
                    if(x < 0 || x >= m || y < 0 || y >= n) {
                        continue;
                    }
                    // oh yes you are already rotten
                    if(grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }

                    // fresh orange is rotting!!!
                    flag = true;
                    grid[x][y] = 2;
                    fresh--;
                    queue.offer(new Orange(x, y));
                }
            }
            if(flag) res++;
        }

        return fresh == 0 ? res : -1;
    }
}
