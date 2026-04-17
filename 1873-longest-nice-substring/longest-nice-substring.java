class Solution {
    
    public String longestNiceSubstring(String s) {
        return helper(s);
    }
    
    private String helper(String s) {
        int n = s.length();
        
        if (n < 2) return "";
        
        // check if string is nice
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            if (s.indexOf(Character.toLowerCase(c)) == -1 ||
                s.indexOf(Character.toUpperCase(c)) == -1) {
                
                // split around bad character
                String left = helper(s.substring(0, i));
                String right = helper(s.substring(i + 1));
                
                return (left.length() >= right.length()) ? left : right;
            }
        }
        
        // if all characters are nice
        return s;
    }
}