class Solution {
    public int minimumArea(int[][] grid) {
        int mini = Integer.MAX_VALUE;
        int maxi = -1;
        int minj = Integer.MAX_VALUE;
        int maxj = -1;
        for(int i = 0 ; i<grid.length;i++){
            for(int j= 0; j<grid[i].length;j++){
                if(grid[i][j] == 1){
                    mini = Math.min(mini , i);
                    maxi = Math.max(maxi , i);
                    minj = Math.min(minj , j);
                    maxj = Math.max(maxj , j);
                }
            }
        }
        int sol = (maxi + 1 - mini ) * (maxj + 1 - minj); 
        // System.out.println(mini + " " + maxi + " " + minj + " " + maxj + " ");
        return sol;
    }
}