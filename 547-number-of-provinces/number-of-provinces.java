class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        System.out.println(n);
        int visited[] = new int[n];
        Arrays.fill(visited , -1);
        int count = 0;
        for ( int i = 0 ; i < n ;i++){
            if(visited[i] == -1){
                dfs(i,isConnected,n,visited);
                count +=1;
            }
        }
        return count;
    }
    public void dfs(int i,int[][] isConnected , int n , int[] visited){
        visited[i] = 1;
        for(int j = 0; j < n; j++){
            if(isConnected[i][j] == 1){
                if(visited[j] == -1){
                dfs(j,isConnected,n,visited);
                }
            }
        }
    }
}