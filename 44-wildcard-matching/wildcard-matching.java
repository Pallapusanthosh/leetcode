class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        int[][] dp = new int[m+1][n+1]; 
        for(int[] row : dp) Arrays.fill(row, -1);
        return f(m, n, s, p, dp) == 1;
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
