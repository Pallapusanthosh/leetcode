class Solution {
    // start comparing from start to end if matches ad 2 + rec(-1,-1 ) not macthes max(both cases )
    public int longestPalindromeSubseq(String s) {
        if(s.length() ==1) return 1;
        if(s.length() <=0) return 0;
        int start = 0;
        int end = s.length()-1;
        int[][] dp = new int[end+1][end+1];
        for(int[] row : dp)
            java.util.Arrays.fill(row, -1);
        return lps(start , end , s ,dp);
    }
    private int lps(int i , int j , String s , int[][] dp){
        if(dp[i][j]!=-1) return dp[i][j];
        if(i > j || i < 0  || j < 0 ) return 0;
        if(i == j ) return dp[i][j] = 1;
        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = 2+ lps(i+1,j-1,s,dp);
        }
        return dp[i][j]=Math.max(lps(i+1,j,s,dp),lps(i,j-1,s,dp));
    }
}