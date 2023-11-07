package LeetCode75.Graphs_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _841_Keys_and_Rooms {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Arrays.fill(visited, false);
        visited[0] = true;
        System.out.println(Arrays.toString(visited));
        dfs(rooms, visited, 0);
        System.out.println(Arrays.toString(visited));
        for(boolean room: visited) {
            if(!room) {
                return false;
            }
        }

        return true;
    }

    public static void dfs(List<List<Integer>> keys, boolean[] visited, int room) {

        for(int i : keys.get(room)) {
            if(!visited[i]){
                visited[i] = true;
                dfs(keys, visited, i);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> r1 = new ArrayList<>();
        r1.add(1);
        List<Integer> r2 = new ArrayList<>();
        r2.add(2);
        List<Integer> r3 = new ArrayList<>();
        r3.add(3);
        List<Integer> r4 = new ArrayList<>();
        rooms.add(r1);
        rooms.add(r2);
        rooms.add(r3);
        rooms.add(r4);

        canVisitAllRooms(rooms);
    }

}
