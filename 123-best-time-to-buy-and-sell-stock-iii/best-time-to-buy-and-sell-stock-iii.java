class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3]; 
    
        for (int day = n - 1; day >= 0; day--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int k = 1; k <= 2; k++) {
                    if (buy == 1) {
                        dp[day][buy][k] = Math.max(
                            -prices[day] + dp[day + 1][0][k],
                            dp[day + 1][1][k]
                        );
                    } else {
                        dp[day][buy][k] = Math.max(
                            prices[day] + dp[day + 1][1][k - 1],
                            dp[day + 1][0][k]
                        );
                    }
                }
            }
        }
        return dp[0][1][2];  // Start with buy allowed, 2 transactions left
    }
}



//dp with memoization


// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int[][][] dp1 = new int[n][2][3]; 
//         for(int i = 0;i<n;i++){
//             for(int j = 0;j<2;j++){
//                 for(int k = 0;k<3;k++){
//                     dp1[i][j][k] =-1;
//                 }
//             }
//         }
//         return dp(0,1,2,prices,dp1);
//     }
//     public int dp(int day, int buy ,int k, int[] prices,int[][][] dp1){
//         if(day >= prices.length) return 0;
//         if(k == 0) return 0;
//         if(dp1[day][buy][k] !=-1) return dp1[day][buy][k];

//         if(buy==1){
//            return dp1[day][buy][k] = Math.max(
//                 -prices[day] + dp(day+1,0,k,prices,dp1),
//                 0 + dp(day+1,1,k,prices,dp1)
//            );
//         }
//         return dp1[day][buy][k] = Math.max(
//              prices[day]  + dp(day+1,1,k-1,prices,dp1),
//               0 + dp(day+1,0,k,prices,dp1)
//         );
//     }
// }


//tabulation