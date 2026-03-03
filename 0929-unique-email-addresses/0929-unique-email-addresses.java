import java.util.*;

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();
        
        for (String email : emails) {
            String[] parts = email.split("@");
            String local = parts[0];
            String domain = parts[1];
            
            // Ignore everything after '+'
            if (local.contains("+")) {
                local = local.substring(0, local.indexOf('+'));
            }
            
            // Remove all '.' from local
            local = local.replace(".", "");
            
            String normalized = local + "@" + domain;
            unique.add(normalized);
        }
        
        return unique.size();
    }

    // Optional main to test
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] emails1 = {
            "test.email+alex@leetcode.com",
            "test.e.mail+bob.cathy@leetcode.com",
            "testemail+david@lee.tcode.com"
        };
        System.out.println(sol.numUniqueEmails(emails1)); // Output: 2

        String[] emails2 = {"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
        System.out.println(sol.numUniqueEmails(emails2)); // Output: 3
    }
}