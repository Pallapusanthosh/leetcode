class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        // indegree array
        int[] indegree = new int[numCourses];

        // build graph
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]); // course dependency: pre[1] → pre[0]
            indegree[pre[0]]++;
        }

        // queue for nodes with indegree 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        int[] order = new int[numCourses];
        int idx = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            order[idx++] = node;

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // if idx != numCourses → cycle exists
        if (idx != numCourses) return new int[0];
        return order;
    }
}
