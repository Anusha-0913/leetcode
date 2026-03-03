import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        
        // Step 1: Initialize union-find parent and email->name mapping
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                parent.putIfAbsent(email, email);
                emailToName.put(email, name);
                union(parent, account.get(1), email); // connect all emails in the account
            }
        }
        
        // Step 2: Group emails by root parent
        Map<String, List<String>> unions = new HashMap<>();
        for (String email : parent.keySet()) {
            String root = find(parent, email);
            unions.computeIfAbsent(root, x -> new ArrayList<>()).add(email);
        }
        
        // Step 3: Build result
        List<List<String>> result = new ArrayList<>();
        for (List<String> emails : unions.values()) {
            Collections.sort(emails);
            List<String> account = new ArrayList<>();
            account.add(emailToName.get(emails.get(0))); // name
            account.addAll(emails);
            result.add(account);
        }
        
        return result;
    }
    
    // Union-Find find
    private String find(Map<String, String> parent, String s) {
        if (!parent.get(s).equals(s)) {
            parent.put(s, find(parent, parent.get(s))); // path compression
        }
        return parent.get(s);
    }
    
    // Union-Find union
    private void union(Map<String, String> parent, String a, String b) {
        String rootA = find(parent, a);
        String rootB = find(parent, b);
        if (!rootA.equals(rootB)) {
            parent.put(rootA, rootB);
        }
    }

    // Optional main to test
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        List<List<String>> accounts1 = Arrays.asList(
            Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"),
            Arrays.asList("John","johnsmith@mail.com","john00@mail.com"),
            Arrays.asList("Mary","mary@mail.com"),
            Arrays.asList("John","johnnybravo@mail.com")
        );
        
        System.out.println(sol.accountsMerge(accounts1));
        // Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"], ["Mary","mary@mail.com"], ["John","johnnybravo@mail.com"]]

        List<List<String>> accounts2 = Arrays.asList(
            Arrays.asList("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"),
            Arrays.asList("Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"),
            Arrays.asList("Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"),
            Arrays.asList("Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"),
            Arrays.asList("Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co")
        );
        System.out.println(sol.accountsMerge(accounts2));
    }
}