class Solution {
    public int numIslands(char[][] grid) {
        
    int m  = grid.length;
    int n = grid[0].length;
    int visited[][] = new int[m][n];
    for(int i = 0; i<m ;i++){ 
        Arrays.fill(visited[i] , -1);
    }
    int count = 0;
    for ( int i = 0 ; i < m ;i++){
        for( int j = 0; j<n;j++){
            if(visited[i][j] == -1 &&  grid[i][j] == '1'){
                dfs(i,j,grid,m,n,visited);
                count +=1;
            }
        }
    }
        return count;
    }
    public void dfs(int i,int j,char[][] grid ,int m, int n , int[][] visited){
    
        if(i < 0 || j < 0 || i>= m || j >=n || grid[i][j]=='0'||visited[i][j] == 1){
            return;
        }
        visited[i][j] = 1;
        
        dfs(i-1,j,grid,m,n,visited);
        dfs(i,j-1,grid,m,n,visited);
        dfs(i,j+1,grid,m,n,visited);
        dfs(i+1,j,grid,m,n,visited);
    }
}