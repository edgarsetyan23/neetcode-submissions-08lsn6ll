class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
        return false;
    }
    
    Map<Character, Integer> charCount = new HashMap<>();
    
    // Count characters in first string
    for (char c : s.toCharArray()) {
        charCount.put(c, charCount.getOrDefault(c, 0) + 1);
    }
    
    // Decrement counts for second string
    for (char c : t.toCharArray()) {
        if (!charCount.containsKey(c) || charCount.get(c) == 0) {
            return false;
        }
        charCount.put(c, charCount.get(c) - 1);
    }
    
    return true;
}
}
