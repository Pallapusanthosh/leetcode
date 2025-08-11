class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //this si typical toplogical sort so we use bfs for toplogical sort
        //we can use dfs with stack add ele in the stack when exploted all children nodes
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<numCourses;i++) adj.add(new ArrayList<>());
        int n= numCourses;

         int[] indegree = new int[numCourses];
        for(int pre[] : prerequisites){
            adj.get(pre[0]).add(pre[1]);
            indegree[pre[1]] +=1;
        }


        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i<n;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int qnode = q.poll();
            ans.add(qnode);
            for(int neigh : adj.get(qnode)){
                indegree[neigh] --;
                if(indegree[neigh] == 0){
                    q.add(neigh);
                }
            }
        }
        if(n == ans.size()){
            return true;
        }
        return false;
    }
}