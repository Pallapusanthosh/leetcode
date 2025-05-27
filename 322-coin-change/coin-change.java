class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m][n + 1];

        // Initialize for coin[0]
        for (int j = 0; j <= n; j++) {
            if (j % coins[0] == 0)
                dp[0][j] = j / coins[0];
            else
                dp[0][j] = Integer.MAX_VALUE - 1; // not possible
        }

        // Fill the rest of the DP table
        for (int i = 1; i < m; i++) {
            for (int j = 0; j <= n; j++) {
                if (coins[i] <= j) {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int result = dp[m - 1][n];
        return result >= Integer.MAX_VALUE - 1 ? -1 : result;
    }
}
