class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
       for(int i = 0 ; i < m - 1 ;i++){
            int loopi = 0;
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = i + 1 ; j < m  ; j++){
               
                list.add(grid[loopi++][j]);
              
            
            }
            int loopi1 = 0;
            Collections.sort(list);
            for(int j = i + 1 ; j < m  ; j++){
               
                grid[loopi1 ++][j] = list.remove(0);
                
            
            }
            
        }
        for(int i = 0 ; i < m ;i++){
            int loopi = i;
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = 0 ; j < m -i ; j++){
                
                list.add(grid[loopi][j]);
               
                loopi++;
            }
            int loopi1 = i;
            Collections.sort(list , Collections.reverseOrder());
            for(int j = 0 ; j < m -i ; j++){
               
                grid[loopi1][j] = list.remove(0);
                
                loopi1++;
            }
            
        }
        return grid;
    }
}