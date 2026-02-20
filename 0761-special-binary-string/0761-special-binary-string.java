import java.util.*;

public class Solution {

    public String makeLargestSpecial(String s) {
        if (s.length() <= 2) return s;

        List<String> list = new ArrayList<>();
        int count = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
            else count--;

            // When count becomes 0, we found a special substring
            if (count == 0) {
                // Recursively solve inner substring
                String inner = s.substring(start + 1, i);
                String processed = "1" + makeLargestSpecial(inner) + "0";
                list.add(processed);
                start = i + 1;
            }
        }

        // Sort in descending order
        Collections.sort(list, Collections.reverseOrder());

        // Join all substrings
        StringBuilder result = new StringBuilder();
        for (String str : list) {
            result.append(str);
        }

        return result.toString();
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.makeLargestSpecial("11011000")); // Output: 11100100
        System.out.println(sol.makeLargestSpecial("10"));       // Output: 10
    }
}