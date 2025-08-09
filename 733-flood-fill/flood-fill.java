class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initial = image[sr][sc];
        if (initial == color) return image;

        int m = image.length;
        int n = image[0].length;
        int[][] dirs = {
            {0,-1},
            {-1,0},
            {0,1},
            {1,0}
        };

        // Copy image
        int[][] newimage = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newimage[i][j] = image[i][j];
            }
        }

        // Start DFS on the copy
        dfs(sr, sc, m, n, newimage, initial, color, dirs);
        return newimage;
    }

    void dfs(int i, int j, int m, int n, int[][] image, int initial, int newcolor, int[][] dirs) {
        if (i < 0 || j < 0 || i >= m || j >= n || image[i][j] != initial) return;

        image[i][j] = newcolor; // color current cell first

        for (int[] dir : dirs) {
            dfs(i + dir[0], j + dir[1], m, n, image, initial, newcolor, dirs);
        }
    }
}
