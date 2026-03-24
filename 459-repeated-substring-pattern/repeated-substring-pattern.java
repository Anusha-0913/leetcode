class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String temp = (s + s).substring(1, (s + s).length() - 1);
        return temp.contains(s);
    }
}