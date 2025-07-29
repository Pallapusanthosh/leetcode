class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
     for(int i =0;i<matrix.length;i++){
            if(target == matrix[i][0]) return true;
            if(target == matrix[i][matrix[0].length -1]) return true;
            if(target > matrix[i][0] && target < matrix[i][matrix[0].length -1]){
                if(search(matrix[i],target)){
                    return true;
                }
            }
        }
        return false;
    }
    boolean search(int[] mat , int target){
        int l = 0;
        int h = mat.length -1;
        
        while(l <=h){
            int mid = l +(h -l)/2;
            
            if(mat[mid] == target){
                return true;
            }
            else if(mat[mid]< target){
                l = mid +1;
            }
            else{
                h = mid -1;
            }
        }
        return false;
    }
}