class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int[][] dirs = {{0,-1},{-1,0},{1,0},{0,1}};
        
        // DFS from all border 'O's
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) dfs(0, j, m, n, visited, grid, dirs);
            if (grid[m - 1][j] == 1) dfs(m - 1, j, m, n, visited, grid, dirs);
        }
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) dfs(i, 0, m, n, visited, grid, dirs);
            if (grid[i][n - 1] == 1) dfs(i, n - 1, m, n, visited, grid, dirs);
        }
        
        // Flip unvisited 'O's to 'X'
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    count +=1;
                }
            }
        }
        return count;
    
    }
    void dfs(int i, int j, int m, int n, int[][] visited, int[][] grid, int[][] dirs) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] == 1 ||grid[i][j] == 0) return;
        visited[i][j] = 1;
        for (int[] dir : dirs) {
            dfs(i + dir[0], j + dir[1], m, n, visited, grid, dirs);
        }
    }
}