package Top_Interview_150.Graph_General;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class _399_Evaluate_Division {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        HashMap<String, HashMap<String, Double>> adjacency = new HashMap<>();
        for(List<String> equation : equations) {
            for(String variable : equation) {
                adjacency.putIfAbsent(variable, new HashMap<>());
            }
        }

        for(int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            adjacency.get(a).put(b, values[i]);
            adjacency.get(b).put(a, 1 / values[i]);
        }

        double[] res = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);

            if(!adjacency.containsKey(a) || !adjacency.containsKey(b)) {
                res[i] = -1.0;
                continue;
            }
            HashSet<String> visited = new HashSet<>();
            res[i] = dfs(a, b, visited, adjacency);
        }

        return res;
    }

    public double dfs(String a, String b, HashSet<String> visited, HashMap<String, HashMap<String, Double>> adjacency) {
        if (a.equals(b)) return 1.0;

        visited.add(a);

        for (Map.Entry<String, Double> neighbour : adjacency.get(a).entrySet()) {
            if (visited.contains(neighbour.getKey())) continue;
            double product = dfs(neighbour.getKey(), b, visited, adjacency);
            if (product != -1.0) {
                return neighbour.getValue() * product;
            }
        }

        return -1.0;
    }
}
