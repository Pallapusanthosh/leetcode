class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m  = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(visited[i], -1);
        }

        int max_area = 0;

        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (visited[i][j] == -1 && grid[i][j] == 1) {
                    int area = dfs(i, j, grid, m, n, visited);
                    max_area = Math.max(max_area, area);
                }
            }
        }

        return max_area;
    }

    public int dfs(int i, int j, int[][] grid, int m, int n, int[][] visited) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0 || visited[i][j] == 1) {
            return 0;
        }

        visited[i][j] = 1;

        int area = 1;

        area += dfs(i - 1, j, grid, m, n, visited); 
        area += dfs(i + 1, j, grid, m, n, visited);
        area += dfs(i, j - 1, grid, m, n, visited);
        area += dfs(i, j + 1, grid, m, n, visited);

        return area;
    }
}
