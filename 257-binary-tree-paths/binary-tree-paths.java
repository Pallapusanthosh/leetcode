class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> sol = new ArrayList<>();
        if (root == null) return sol;
        dfs(root, sol, "");
        return sol;
    }

    public void dfs(TreeNode root, List<String> sol, String path) {
        if (root == null) return;

        // Build the path string
        path += root.val;

        // If it's a leaf, add to solution
        if (root.left == null && root.right == null) {
            sol.add(path);
            return;
        }

        // Recurse with added "->"
        dfs(root.left, sol, path + "->");
        dfs(root.right, sol, path + "->");
    }
}
