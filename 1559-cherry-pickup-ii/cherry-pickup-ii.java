class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        //top down approach
        // int[][][] dp = new int[rows][cols][cols];
        // return pickup(0, 0, cols - 1, rows, cols, grid , dp);


        //bottomup

        // declare the dp memo
        int[][][] memo = new int[rows][cols][cols];
        //cover the base cases
        int k = rows -1;
        for(int j1 = 0 ; j1 < cols ; j1++){
            for(int j2 = 0 ; j2 < cols ; j2++){
                if(j1 == j2) memo[k][j1][j2] = grid[k][j1];
                else memo[k][j1][j2] = grid[k][j1] + grid[k][j2]; 
            }
        }
        //loops
        for(int i = rows -2 ; i >= 0 ;i--){
            for(int j1 = 0 ; j1 < cols ; j1 ++){
                for(int j2 =0 ; j2 < cols ;j2 ++){
                   
                    int cherries = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];

                    int maxi = Integer.MIN_VALUE;
                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {
                            if(j1 + dj1 >=0 && j1 + dj1 < cols  && j2 + dj2 >= 0 && j2 + dj2 < cols ){
                                 maxi = Math.max(maxi, cherries + memo[i + 1][j1 + dj1][j2 + dj2]);
                            }
                           
                        }
                    }
                    memo[i][j1][j2] = maxi;
    


                }
            }
        }
        return memo[0][0][cols-1];

    }

    // int pickup(int i, int j1, int j2, int rows, int cols, int[][] grid ,  int[][][] dp ) {
    //     // out of bounds
    //     if (j1 < 0 || j1 >= cols || j2 < 0 || j2 >= cols) {
    //         return Integer.MIN_VALUE;
    //     }
    //     if(dp[i][j1][j2]!=0){
    //         return dp[i][j1][j2];
    //     }
    //     // base case
    //     if (i == rows - 1) {
    //         if (j1 == j2) return grid[i][j1];
    //         return grid[i][j1] + grid[i][j2];
    //     }

    //     int cherries = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];

    //     int maxi = Integer.MIN_VALUE;
    //     for (int dj1 = -1; dj1 <= 1; dj1++) {
    //         for (int dj2 = -1; dj2 <= 1; dj2++) {
    //             maxi = Math.max(maxi, cherries + pickup(i + 1, j1 + dj1, j2 + dj2, rows, cols, grid , dp));
    //         }
    //     }
    //     dp[i][j1][j2] = maxi;
    //     return maxi;
    // }


}
