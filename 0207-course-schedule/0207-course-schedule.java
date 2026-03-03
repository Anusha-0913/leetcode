import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course); 
        }
        
        int[] visited = new int[numCourses]; 

        
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (hasCycleDFS(adj, visited, i)) return false;
            }
        }
        return true;
    }
    
    private boolean hasCycleDFS(List<List<Integer>> adj, int[] visited, int node) {
        visited[node] = 1;
        for (int neighbor : adj.get(node)) {
            if (visited[neighbor] == 1) return true;
            if (visited[neighbor] == 0 && hasCycleDFS(adj, visited, neighbor)) return true;
        }
        visited[node] = 2; 
        return false;
    }

   
    public static void main(String[] args) {
        Solution sol = new Solution();

        int numCourses1 = 2;
        int[][] prerequisites1 = {{1,0}};
        System.out.println(sol.canFinish(numCourses1, prerequisites1));

        int numCourses2 = 2;
        int[][] prerequisites2 = {{1,0},{0,1}};
        System.out.println(sol.canFinish(numCourses2, prerequisites2));
    }
}