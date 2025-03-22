import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        Map<Integer, Set<Integer>> componentMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
            componentMap.put(i, new HashSet<>(Arrays.asList(i)));
        }

        for (int[] edge : edges) {
            int rootX = find(edge[0], parent);
            int rootY = find(edge[1], parent);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                    componentMap.get(rootX).addAll(componentMap.get(rootY));
                    componentMap.remove(rootY);
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                    componentMap.get(rootY).addAll(componentMap.get(rootX));
                    componentMap.remove(rootX);
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                    componentMap.get(rootX).addAll(componentMap.get(rootY));
                    componentMap.remove(rootY);
                }
            }
        }

        int completeCount = 0;
        for (Set<Integer> component : componentMap.values()) {
            int size = component.size();
            int edgeCount = 0;
            for (int[] edge : edges) {
                if (component.contains(edge[0]) && component.contains(edge[1])) {
                    edgeCount++;
                }
            }
            if (edgeCount == (size * (size - 1)) / 2) {
                completeCount++;
            }
        }
        return completeCount;
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }
}
