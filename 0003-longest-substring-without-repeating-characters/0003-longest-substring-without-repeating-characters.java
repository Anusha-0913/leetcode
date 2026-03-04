import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int start = 0; 

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);

            
            if (map.containsKey(c)) {
                
                start = Math.max(map.get(c) + 1, start);
            }

            map.put(c, end); 
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}