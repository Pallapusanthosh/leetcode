class Solution {
    public int longestIncreasingPath(int[][] matrix) {
     //intiall thinking was to travrse for each value and check ist length max (m  * n) time takes
      int m = matrix.length;
      int n = matrix[0].length;
      int[][] dp = new int[m][n];
      int dirs[][] = {
        {-1,0},{0,-1},{0,1},{1,0}
      };
      int maxlis = 0;
      for(int i = 0 ; i < m ; i++){
        for(int j = 0 ; j< n ; j++){
            maxlis = Math.max(maxlis,f(i,j ,m , n, dp , dirs , matrix)); 
        }
      }
      return maxlis;
    }
     int f(int i, int j, int m, int n, int[][] dp, int[][] dirs, int[][] matrix) {
    if (dp[i][j] != 0) return dp[i][j];  // base case: already computed

    int maxLen = 1;  // at least this cell counts

    for (int[] dir : dirs) {
        int newi = i + dir[0];
        int newj = j + dir[1];

        if (newi >= 0 && newi < m && newj >= 0 && newj < n) {
            if (matrix[i][j] < matrix[newi][newj]) {
                maxLen = Math.max(maxLen, 1 + f(newi, newj, m, n, dp, dirs, matrix));
            }
        }
    }

    return dp[i][j] = maxLen;  // memoize
    }

}