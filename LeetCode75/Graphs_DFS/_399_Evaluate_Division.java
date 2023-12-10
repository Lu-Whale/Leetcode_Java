package LeetCode75.Graphs_DFS;

import java.util.*;

public class _399_Evaluate_Division {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        HashMap<String, HashMap<String, Double>> e = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);

            e.putIfAbsent(from, new HashMap<>());
            e.get(from).put(to, values[i]);
            // e.computeIfAbsent(from, k -> new HashMap<>()).put(to, values[i]);

            e.putIfAbsent(to, new HashMap<>());
            e.get(to).put(from, 1.0 / values[i]);
        }

        double[] res = new double[queries.size()];

        for(int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            if(!e.containsKey(query.get(0)) || !e.containsKey(query.get(1))) {
                res[i] = -1.0;
                continue;
            }

            res[i] = dfs(query.get(0), query.get(1), 1.0, new HashSet<>(), e);
        }

        return res;
    }

    public double dfs(String current, String target, double ans, Set<String> path, HashMap<String, HashMap<String, Double>> e) {
        if(path.contains(current)) {
            return -1.0;
        }

        if(current.equals(target)) {
            return ans;
        }
        path.add(current);

        for(Map.Entry<String, Double> entry : e.get(current).entrySet()) {
            double temp = dfs(entry.getKey(), target, ans * entry.getValue(), path, e);

            if(temp != -1.0) {
                return temp;
            }
        }

        return -1.0;
    }
}
