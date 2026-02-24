import java.util.*;

public class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        if (source == destination) {
            return true;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    if (neighbor == destination) {
                        return true;
                    }
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        return false;
    }
}