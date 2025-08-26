class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        int[][] dp = new int[m+1][n+1]; 
        //base cases
         dp[0][0] = 1; // empty string matches empty pattern

        // when s is empty, p must be all '*'
        for (int j = 1; j <= n; j++) {
            boolean allStars = true;
            for (int k = 1; k <= j; k++) {
                if (p.charAt(k-1) != '*') {
                    allStars = false;
                    break;
                }
            }
            dp[0][j] = allStars ? 1 : 0;
        }

        for(int i = 1; i<= m ;i++){
                for(int j = 1; j<=n;j++){
                 
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                         dp[i][j] = dp[i-1][ j-1];
                } else if(p.charAt(j-1) == '*') {
                    // '*' matches empty (j-1) or one char (i-1)
                    if(dp[i-1][ j] == 1 || dp[i][j-1] == 1)
                        dp[i][j] = 1;
                 }else{
                    dp[i][j] = 0;
                 }
     

            }
            
            //loops
        }
        return dp[m][n] == 1;
        // for(int[] row : dp) Arrays.fill(row, -1);
        // return f(m, n, s, p, dp) == 1;
    }

    int f(int i, int j, String s, String p, int[][] dp) {
        if(i == 0 && j == 0) return 1;
        if(i != 0 && j == 0) return 0;
        if(i == 0 && j != 0) {
            for(int k = 1; k <= j; k++) {
                if(p.charAt(k-1) != '*') return 0;
            }
            return 1;
        }

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
            return dp[i][j] = f(i-1, j-1, s, p, dp);
        } else if(p.charAt(j-1) == '*') {
            // '*' matches empty (j-1) or one char (i-1)
            if(f(i-1, j, s, p, dp) == 1 || f(i, j-1, s, p, dp) == 1)
                return dp[i][j] = 1;
        }
        return dp[i][j] = 0;
    }
}
