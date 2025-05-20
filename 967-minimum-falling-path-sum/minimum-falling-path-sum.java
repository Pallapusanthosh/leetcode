class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        Integer[][] memo = new Integer[n][n];
        int minPath = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            minPath = Math.min(minPath, dfs(0, j, matrix, memo));
        }

        return minPath;
    }

    private int dfs(int i, int j, int[][] matrix, Integer[][] memo) {
        int n = matrix.length;

        
        if (j < 0 || j >= n) return Integer.MAX_VALUE;

        
        if (i == n - 1) return matrix[i][j];

    
        if (memo[i][j] != null) return memo[i][j];

        int left = dfs(i + 1, j - 1, matrix, memo);
        int down = dfs(i + 1, j, matrix, memo);
        int right = dfs(i + 1, j + 1, matrix, memo);


        memo[i][j] = matrix[i][j] + Math.min(left, Math.min(down, right));
        return memo[i][j];
    }
}
