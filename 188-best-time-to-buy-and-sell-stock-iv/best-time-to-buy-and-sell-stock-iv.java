class Solution {
    public int maxProfit(int k,int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][k+1]; 
    
        for (int day = n - 1; day >= 0; day--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int k1 = 1; k1 <= k; k1++) {
                    if (buy == 1) {
                        dp[day][buy][k1] = Math.max(
                            -prices[day] + dp[day + 1][0][k1],
                            dp[day + 1][1][k1]
                        );
                    } else {
                        dp[day][buy][k1] = Math.max(
                            prices[day] + dp[day + 1][1][k1 - 1],
                            dp[day + 1][0][k1]
                        );
                    }
                }
            }
        }
        return dp[0][1][k];  // Start with buy allowed, 2 transactions left
    }
}