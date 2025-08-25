class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int no = m * n;
        int[] ans = new int[no];
        int idx = 0;

        for(int i = 0; i < m + n - 1; i++){
            int startRow = Math.max(0, i - (n - 1));
            int endRow = Math.min(m - 1, i);
            int noofele = endRow - startRow + 1;

            int r, c;
            if(i % 2 == 0){ // go up-right
                r = endRow;
                c = i - r;
                for(int j = 0; j < noofele; j++){
                    ans[idx++] = mat[r][c];
                    r--; c++;
                }
            }else{ // go down-left
                r = startRow;
                c = i - r;
                for(int j = 0; j < noofele; j++){
                    ans[idx++] = mat[r][c];
                    r++; c--;
                }
            }
        }
        return ans;
    }
}
