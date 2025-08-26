class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m == 0 || n == 0) return 0;
        int[][] dp = new int[m+1][n+1];

        //base cases
        for(int i = 0; i <= m;i++){
            dp[i][0] = 1; 
        }
        for(int i = 1; i<= m ;i++){
            for(int j = 1; j<=n;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
        // return f(m-1,n-1,s,t , dp);
    }
    int f(int i , int j , String s , String t , int[][] dp){
        if(j < 0) return 1;
        if(i < 0) return 0;
        if(dp[i][j] !=0) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)){
            //we need to check the no of subsequemces possible of t in s;
            //so if it matches it good we can move i-1, j-1 it is ok when we have only possible subsequence but it is not we have multiple we reduce i-1, j keep as it is 
            //if it mismatches then we can go i-1,j beacuse in future j czan ba matched
            return dp[i][j] = f(i-1,j-1,s,t , dp) + f(i-1 , j , s,t , dp);
        }
        return dp[i][j] =  f(i-1, j , s,t , dp);
    }
}