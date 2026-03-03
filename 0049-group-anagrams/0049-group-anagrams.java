import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        
        return new ArrayList<>(map.values());
    }

    // Optional main to test
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        String[] strs1 = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(sol.groupAnagrams(strs1));
        // Output: [["eat","tea","ate"],["tan","nat"],["bat"]]

        String[] strs2 = {""};
        System.out.println(sol.groupAnagrams(strs2));
        // Output: [[""]]

        String[] strs3 = {"a"};
        System.out.println(sol.groupAnagrams(strs3));
        // Output: [["a"]]
    }
}
