class Solution {
    public long flowerGame(int n, int m) {
        long oddRows = (n + 1) / 2;
        long evenRows = n / 2;
        long oddCols = (m + 1) / 2;
        long evenCols = m / 2;

        return oddRows * evenCols + evenRows * oddCols;
    }

}