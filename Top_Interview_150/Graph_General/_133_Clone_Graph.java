package Top_Interview_150.Graph_General;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class _133_Clone_Graph {

    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        Map<Node, Node> visited = new HashMap<>();

        return dfs(node, visited);
    }

    public Node dfs(Node node, Map<Node, Node> visited) {
        if(node == null) return null;
        if(visited.containsKey(node)) {
            return visited.get(node);
        }
        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);

        for(Node n : node.neighbors) {
           cloneNode.neighbors.add(dfs(n, visited));
        }

        return cloneNode;
    }
}

class solution_133 {
    private HashMap<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        if(visited.containsKey(node)) {
            return visited.get(node);
        }

        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);

        for(Node n : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(n));
        }

        return cloneNode;
    }
}












