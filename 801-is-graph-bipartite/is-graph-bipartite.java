class Solution {
    public boolean isBipartite(int[][] graph) {
        int m = graph.length;
        int[] visited = new int[m];
        int[] color = new int[m]; // 0 = uncolored, 1 & 2 = two colors

        for (int i = 0; i < m; i++) {
            if (visited[i] == 0) {
                if (!dfs(graph, visited, color, i,1)) {
                    return false;
                }
            }
        }
        return true;
    }
     boolean dfs(int[][] graph, int[] visited, int[] color, int start , int col){
          visited[start] = 1;
          color[start] = col;
          
          for(int neigh : graph[start]){
              if(visited[neigh] !=1){
                int childcol = 3- col;
                if(!dfs(graph, visited,color , neigh,childcol)){
                    return false;
                }
              }else if(color[neigh]==col){
                  return false;
              }
          }
          return true;
      }
    boolean bfs(int[][] graph, int[] visited, int[] color, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 1;
        color[start] = 1;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbor : graph[node]) {
                if (visited[neighbor] == 0) {
                    visited[neighbor] = 1;
                    color[neighbor] = 3 - color[node]; // toggle between 1 and 2
                    q.add(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false; // same color on both ends of an edge → not bipartite
                }
            }
        }
        return true;
    }
}
