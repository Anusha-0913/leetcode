import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = sumOfSquares(n);
        }
        
        return n == 1;
    }
    
    // Helper to compute sum of squares of digits
    private int sumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
    
    // Optional main method to test
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isHappy(19)); // true
        System.out.println(sol.isHappy(2));  // false
        System.out.println(sol.isHappy(7));  // true
        System.out.println(sol.isHappy(4));  // false
    }
}