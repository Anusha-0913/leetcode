import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i,j});
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0], y = cell[1];
            
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (dist[nx][ny] > dist[x][y] + 1) {
                        dist[nx][ny] = dist[x][y] + 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        
        return dist;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] mat1 = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(Arrays.deepToString(sol.updateMatrix(mat1)));
        

        int[][] mat2 = {{0,0,0},{0,1,0},{1,1,1}};
        System.out.println(Arrays.deepToString(sol.updateMatrix(mat2)));
        
    }
}