import java.util.*;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor == color) return image; 
        int m = image.length;
        int n = image[0].length;
        dfs(image, sr, sc, originalColor, color, m, n);
        return image;
    }
    
    private void dfs(int[][] image, int i, int j, int originalColor, int newColor, int m, int n) {
        
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        
        if (image[i][j] != originalColor) return;
        
        image[i][j] = newColor;
        
       
        dfs(image, i + 1, j, originalColor, newColor, m, n);
        dfs(image, i - 1, j, originalColor, newColor, m, n);
        dfs(image, i, j + 1, originalColor, newColor, m, n);
        dfs(image, i, j - 1, originalColor, newColor, m, n);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] image1 = {
            {1,1,1},
            {1,1,0},
            {1,0,1}
        };
        int sr1 = 1, sc1 = 1, color1 = 2;
        int[][] result1 = sol.floodFill(image1, sr1, sc1, color1);
        System.out.println(Arrays.deepToString(result1));
        
        int[][] image2 = {
            {0,0,0},
            {0,0,0}
        };
        int sr2 = 0, sc2 = 0, color2 = 0;
        int[][] result2 = sol.floodFill(image2, sr2, sc2, color2);
        System.out.println(Arrays.deepToString(result2));
        
    }
}