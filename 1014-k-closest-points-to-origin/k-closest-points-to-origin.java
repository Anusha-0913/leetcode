import java.util.*;

class Solution {
    
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> distance(a) - distance(b)
        );
        
        for (int[] p : points) {
            pq.offer(p);
        }
        
        int[][] result = new int[k][2];
        
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        
        return result;
    }
    
    private int distance(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}
