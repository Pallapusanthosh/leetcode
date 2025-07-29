class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int l = 0;
        int h = mat[0].length - 1; // fix: h should be mat[0].length - 1

        while (l <= h) {
            int mid = l + (h - l) / 2;
            int row = maxi(mat, mid); // get row index with max value in column 'mid'

            int left = (mid - 1 >= 0) ? mat[row][mid - 1] : -1;
            int right = (mid + 1 < mat[0].length) ? mat[row][mid + 1] : -1;

            if (mat[row][mid] > left && mat[row][mid] > right) {
                return new int[]{row, mid};
            } else if (left > mat[row][mid]) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return new int[]{-1, -1}; // fallback (never reached for guaranteed peak)
    }

    // returns the index of the row with the maximum value in a given column
    int maxi(int[][] mat, int col) {
        int maxRow = 0;
        for (int i = 1; i < mat.length; i++) {
            if (mat[i][col] > mat[maxRow][col]) {
                maxRow = i;
            }
        }
        return maxRow;
    }
}
