class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int n = rooms.size();
        int visited[] = new int[n];
        Arrays.fill(visited , -1);
        int count = 0;
        dfs(0,rooms, n, visited);
        for(int i = 0; i< n ;i++){
            if(visited[i] == -1){
                return false;
            }
        }
        return true;
    }
    public void dfs(int i,List<List<Integer>> rooms, int n , int[] visited){
        visited[i] = 1;
        List<Integer> row = rooms.get(i);
        for( int j : row){
            if(visited[j] == -1){
               dfs(j,rooms,n,visited);
            }
        }
    }
}