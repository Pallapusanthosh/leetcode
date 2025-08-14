class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        ArrayList<Integer> unvisited = new ArrayList<>();
        for (int num : nums) unvisited.add(num);


         unvisited.sort(Integer::compareTo);
        dfs(sol, new ArrayList<>(), unvisited, nums.length);
        return sol;
    }

    void dfs(List<List<Integer>> sol, ArrayList<Integer> visited, ArrayList<Integer> unvisited, int n) {
        if (visited.size() == n) {
            sol.add(new ArrayList<>(visited)); // store permutation
            return;
        }

        for (int i = 0; i < unvisited.size(); i++) {
            if (i > 0 && unvisited.get(i).equals(unvisited.get(i-1))) continue;

            int x = unvisited.remove(i);   // pick
            visited.add(x);                // mark as visited

            dfs(sol, visited, unvisited, n); // recurse

            visited.remove(visited.size() - 1); // unmark
            unvisited.add(i, x);               // put back
        }
    }
}
