class Solution {
    public boolean isBipartite(int[][] graph) {
        //bfs 
        int m =graph.length;
        int n= graph[0].length;
        //graph given as arraylist;
        //means at 0 index ele have an edge in graph[0];
        int[] visited =new int[m];
        int[] color = new int[m];
         for (int i = 0; i < m; i++) {
            if (visited[i] == 0) {
                if (!bfs(graph, visited, color, i)) {
                    return false;
                }
            }
        }
        return true;
    }
    boolean bfs(int[][] graph , int[] visited , int[] color , int start ){
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{start,1});
        // int color = 1;
        while(!q.isEmpty()){
            int[] curnode = q.poll();
            int node = curnode[0];
            int col = curnode[1];
            visited[node] = 1;
            color[node] = col;
           
            int size = graph[node].length;
            for(int i = 0;i<size;i++){
                int child = graph[node][i];
                int childcol = col == 1 ? 2 : 1;
                if(visited[child]==0){
                    q.add(new int[]{child,childcol});
                }
                else{
                    int childcol2 = color[child];
                    if(col == childcol2){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}