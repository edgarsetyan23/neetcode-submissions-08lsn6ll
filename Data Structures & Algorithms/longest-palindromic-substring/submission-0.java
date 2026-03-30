class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0) return "";
        int start = 0, end = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1])) {
                dp[i][j] = true;
                if (j - i > end - start) {
                    start = i;
                    end = j;
                }
            }
        }
    }
        return s.substring(start, end + 1);
    }
}
