class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int [][] dp = new int[m + 1][n + 1];
        //bottom up 
     
        for(int i = 0 ; i<= m ; i++){
            dp[i][0] = 0;
        }
        for(int i = 0; i<=n;i++){
            dp[0][i]  = 0;
        }
        for(int i = 1 ; i <= m ;i++){
            for(int j =1; j <= n ;j++){
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                     dp[i][j] = 1 + dp[i - 1][ j - 1];
                }
                else{
                     dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }

               
            }
        }
        return dp[m][n];
        // return lcs(m, n, text1, text2, dp);
    }

    public int lcs(int m, int n, String text1, String text2, int[][] dp) {
        if (m == 0 || n == 0) return 0;
        if (dp[m][n] != -1) return dp[m][n];

        if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
            return dp[m][n] = 1 + lcs(m - 1, n - 1, text1, text2, dp);
        }

        return dp[m][n] = Math.max(lcs(m - 1, n, text1, text2, dp),
                                   lcs(m, n - 1, text1, text2, dp));
    }
}