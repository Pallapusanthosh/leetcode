class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxlen = -1;
        int maxarea = 0;
        for(int[] dim : dimensions){
            int prod = (dim[0] * dim[0])  + (dim[1] * dim[1]);
            double dlen = Math.sqrt(prod);
            int area = dim[0] * dim[1];
            if(dlen > maxlen || (dlen == maxlen && area > maxarea)){
                maxlen = dlen;
                maxarea = area;
            }
        }
        return maxarea;
    }
}
