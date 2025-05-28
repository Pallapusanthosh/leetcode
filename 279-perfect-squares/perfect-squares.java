class Solution {
    public int numSquares(int n) {
         int n1 = (int)Math.round(Math.sqrt(n));
         int squares[] = new int[n1];
          for(int i = 0 ; i <n1 ; i++){
                squares[i] = (i+1) * (i+1);
                System.out.println(squares[i]);
           }
        int m = squares.length;
        int[][] dp = new int[m][n + 1];

        // Initialize for coin[0]
        for (int j = 0; j <= n; j++) {
            if (j % squares[0] == 0)
                dp[0][j] = j / squares[0];
            else
                dp[0][j] = Integer.MAX_VALUE - 1; // not possible
        }

        // Fill the rest of the DP table
        for (int i = 1; i < m; i++) {
            for (int j = 0; j <= n; j++) {
                if (squares[i] <= j) {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - squares[i]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int result = dp[m - 1][n];
        return result >= Integer.MAX_VALUE - 1 ? -1 : result;
    }
}