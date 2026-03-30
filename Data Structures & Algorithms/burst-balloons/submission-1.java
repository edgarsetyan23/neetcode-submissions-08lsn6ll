

class Solution {
    public int maxCoins(int[] nums) {
        // Create a new list with boundary balloons
        List<Integer> newNums = new ArrayList<>();
        newNums.add(1);
        for (int num : nums) {
            newNums.add(num);
        }
        newNums.add(1);
        
        int n = newNums.size();
        
        // Initialize DP table
        int[][] dp = new int[n][n];
        
        // Fill the DP table
        for (int length = 2; length < n; length++) {
            for (int left = 0; left < n - length; left++) {
                int right = left + length;
                for (int i = left + 1; i < right; i++) {
                    int coins = newNums.get(left) * newNums.get(i) * newNums.get(right);
                    coins += dp[left][i] + dp[i][right];
                    dp[left][right] = Math.max(dp[left][right], coins);
                }
            }
        }
        
        // Return the maximum coins
        return dp[0][n-1];
    }
}