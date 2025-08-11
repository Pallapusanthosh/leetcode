class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] visited = new int[m][n];
        int[][] dirs = {{0,-1},{-1,0},{1,0},{0,1}};
        
        // DFS from all border 'O's
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') dfs(0, j, m, n, visited, board, dirs);
            if (board[m - 1][j] == 'O') dfs(m - 1, j, m, n, visited, board, dirs);
        }
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(i, 0, m, n, visited, board, dirs);
            if (board[i][n - 1] == 'O') dfs(i, n - 1, m, n, visited, board, dirs);
        }
        
        // Flip unvisited 'O's to 'X'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && visited[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    void dfs(int i, int j, int m, int n, int[][] visited, char[][] board, int[][] dirs) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] == 1 || board[i][j] != 'O') return;
        visited[i][j] = 1;
        for (int[] dir : dirs) {
            dfs(i + dir[0], j + dir[1], m, n, visited, board, dirs);
        }
    }
}
