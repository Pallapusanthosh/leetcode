class Solution {
    public long coloredCells(int n) {
        if(n == 1){
            return 1;
        }
        else if (n == 2){
            return 5;
        }
        else{
            return (((n + (n - 1)) * 2 - 1) + (((long)(0.5 * n * n) - (long)(1.5 * n) + 1) * 4));
        }
    }
}