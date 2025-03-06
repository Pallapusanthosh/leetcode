class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int n1 = n*n;
        int sum = (n1*(n1+1))/2;
        int given_sum = 0;
        int [] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>(); 
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                map.put(grid[i][j],map.getOrDefault(grid[i][j],0) + 1);
                given_sum += grid[i][j];
            }
        }
        int key = 0;
        for (var entry : map.entrySet()) {
            if(entry.getValue() == 2){
                key = entry.getKey();
            }  
        }
        result[0] = key;
        result[1] = sum - (given_sum - key);

        return result;
    }
}