class Solution {
    public int countSubstrings(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
        for (int j = i; j < s.length(); j++) {
            int start = i, end = j;
            boolean isPalindrome = true;
            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) {
                    isPalindrome = false;
                    break;
                }
                start++;
                end--;
            }
            if (isPalindrome) {
                count++;
            }
        }
    }
    return count;
}
}
