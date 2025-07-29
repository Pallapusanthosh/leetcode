class Solution {
    public void gameOfLife(int[][] board) {
        int dir[][] = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
        };
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = check(board, i, j, dir, m, n);
                if (board[i][j] == 1 && val == 0) board[i][j] = -1;
                if (board[i][j] == 0 && val == 1) board[i][j] = 2;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) board[i][j] = 0;
                if (board[i][j] == 2) board[i][j] = 1;
            }
        }
    }

    int check(int[][] board, int i, int j, int[][] dir, int m, int n) {
        int neigh = 0;
        for (int[] dirs : dir) {
            int x = i + dirs[0];
            int y = j + dirs[1];
            if (x >= 0 && y >= 0 && x < m && y < n) {
                if (Math.abs(board[x][y]) == 1) {
                    neigh++;
                }
            }
        }
        if (board[i][j] == 1) {
            if (neigh < 2 || neigh > 3) return 0;
            return 1;
        } else {
            if (neigh == 3) return 1;
        }
        return 0;
    }
}
