class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int current_sum = triangle.get(0).get(0);
        int n = triangle.size();
        int[][] matrix  = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j <= i; j++)
                matrix[i][j] = -1;
        return cal_sum(triangle, 0, 0, n , matrix);

    }

    public int cal_sum(List<List<Integer>> tri, int i, int j, int n,int matrix[][]) {
        if(matrix[i][j]!=-1){
            return matrix[i][j];
        }
        if(i == n - 1){
            return tri.get(i).get(j);
        }

        int left = cal_sum(tri, i + 1, j, n,matrix);
        int right = cal_sum(tri, i + 1, j + 1, n,matrix);
        int value = tri.get(i).get(j) + Math.min(left, right);
        matrix[i][j] = value;
        return value;
    }
}
