class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //build adjacency list
        if (n == 1) return Arrays.asList(0);

        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new HashSet<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        //leaves
        ArrayList<Integer> leaves = new ArrayList<>();
        for(int i = 0 ; i<n ; i++){
            if(adj.get(i).size() == 1){
                leaves.add(i);
            }
        }
        // for(int num : leaves){
        //     System.out.println(num);
        // }
        int remaining = n;
        while( remaining > 2){
            remaining -= leaves.size();
       
            //new leaves
            ArrayList<Integer> newLeaves  = new ArrayList<>();
            //reduce old leaves

           for (int leaf : leaves) {
                int neighbor = adj.get(leaf).iterator().next();  // the only neighbor
                adj.get(neighbor).remove(leaf);  // remove leaf from neighbor
                if (adj.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
            }
            
           
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}