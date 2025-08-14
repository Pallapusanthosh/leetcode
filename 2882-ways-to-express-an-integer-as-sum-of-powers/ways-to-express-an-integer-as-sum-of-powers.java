class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfWays(int n, int x) {
        int maxBase = 1;
        while (Math.pow(maxBase, x) <= n) {
            maxBase++;
        }
        maxBase--;
        int[][] matrix = new int[n + 1][maxBase + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= maxBase; j++) {
                matrix[i][j] = -1; // mark as uncomputed
            }
        }
        return dfs(n, maxBase, x, matrix);
    }

    int dfs(int n, int base, int x, int[][] matrix) {
        if (n == 0) return 1;
        if (n < 0 || base == 0) return 0;

        if (matrix[n][base] != -1) return matrix[n][base];

        int without = dfs(n, base - 1, x, matrix);
        int with = dfs(n - (int) Math.pow(base, x), base - 1, x, matrix);

        matrix[n][base] = (int) (((long) without + with) % MOD);
        return matrix[n][base];
    }
}
