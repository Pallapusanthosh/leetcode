import java.util.*;

class Solution {
    boolean cycle = false; // Global cycle flag

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[] visited = new int[n]; // For tracking visited nodes during DFS
        List<List<Integer>> adj = new ArrayList<>();
        int[][] longest = new int[26][n]; // To track longest path for each color at each node

        // Initialize adjacency list for the graph
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Fill adjacency list based on the edges
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        // Start DFS for each unvisited node
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(i, visited, adj, n, longest, colors);
            }
        }

        // Calculate the maximum color value across all nodes and colors
        int max_value = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < n; j++) {
                max_value = Math.max(max_value, longest[i][j]);
            }
        }

        // If a cycle is detected, return -1
        if (cycle) return -1;

        return max_value; // Return the largest path value
    }

    // Depth-First Search (DFS) to traverse the graph and calculate the longest path for each color
    public void dfs(int i, int[] visited, List<List<Integer>> adj, int n, int[][] longest, String colors) {
        visited[i] = 1; // Mark the node as being visited (1)
        
        // Explore each adjacent node
        for (int j : adj.get(i)) {
            if (visited[j] == 0) {
                dfs(j, visited, adj, n, longest, colors);
                copy(j, i, longest); // Copy longest paths from child to parent
            } else if (visited[j] == 1) {
                cycle = true; // Cycle detected
            }else if(visited[j] == 2){
                copy(j,i,longest);
            }
        }

        // Update the longest path for the current node and its color
        longest[colors.charAt(i) - 'a'][i] += 1;
        visited[i] = 2; // Mark the node as fully visited (2)
    }

    // Copy the longest path values from a child node to the parent node
    public void copy(int start, int target, int[][] longest) {
        for (int i = 0; i < 26; i++) {
            longest[i][target] = Math.max(longest[i][target], longest[i][start]);
        }
    }
}
