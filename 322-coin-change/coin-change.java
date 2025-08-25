class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m][n + 1];
       
        // int res = f(m-1 , n , coins , dp);
        //base cases
        for(int i  = 0 ; i< n+1;i++){
            dp[0][i] = i % coins[0] == 0 ? i/ coins[0] : (int)1e9;
        }
        for(int i = 1 ; i < m;i++){
            for(int j = 0 ; j< n+1;j++){
                int nottake = dp[i-1][j];
                int take = (int)1e9;
                if(coins[i] <= j){
                    take = 1 + dp[i][j - coins[i]];
                }
                dp[i][j] = Math.min(take, nottake);
                // return dp[i][target];
            }
        }
        int res = dp[m-1][n];
        return res >=(int)1e9  ? -1 : res;




        // // Initialize for coin[0]
        // for (int j = 0; j <= n; j++) {
        //     if (j % coins[0] == 0)
        //         dp[0][j] = j / coins[0];
        //     else
        //         dp[0][j] = Integer.MAX_VALUE - 1; // not possible
        // }

        // // Fill the rest of the DP table
        // for (int i = 1; i < m; i++) {
        //     for (int j = 0; j <= n; j++) {
        //         if (coins[i] <= j) {
        //             dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i]]);
        //         } else {
        //             dp[i][j] = dp[i - 1][j];
        //         }
        //     }
        // }

        // int result = dp[m - 1][n];
        // return result >= Integer.MAX_VALUE - 1 ? -1 : result;
    }
//    int f(int i ,int target , int[] coins , int[][] dp){
//     if(dp[i][target]!=0) return dp[i][target];
//     if(i == 0){
//         if(target % coins[0] == 0) return target / coins[0];
//         return (int)1e9; 
//     }

//     int nottake = f(i-1, target, coins , dp);
//     int take = (int)1e9;
//     if(coins[i] <= target){
//         take = 1 + f(i, target - coins[i], coins , dp);
//     }
//     dp[i][target] = Math.min(take, nottake);
//     return dp[i][target];
// }

}
