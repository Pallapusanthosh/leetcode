/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // Map each node to its parent
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        mapParents(root, parent);

        List<Integer> ans = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();

        dfs(target, parent, visited, 0, k, ans);
        return ans;
    }

    void dfs(TreeNode node, HashMap<TreeNode, TreeNode> parent, Set<TreeNode> visited, int dist, int k, List<Integer> ans) {
        if (node == null || visited.contains(node)) return;

        visited.add(node);

        if (dist == k) {
            ans.add(node.val);
            return;
        }

        dfs(node.left, parent, visited, dist + 1, k, ans);
        dfs(node.right, parent, visited, dist + 1, k, ans);
        dfs(parent.get(node), parent, visited, dist + 1, k, ans);
    }

    void mapParents(TreeNode node, HashMap<TreeNode, TreeNode> parent) {
        if (node == null) return;
        if (node.left != null) {
            parent.put(node.left, node);
            mapParents(node.left, parent);
        }
        if (node.right != null) {
            parent.put(node.right, node);
            mapParents(node.right, parent);
        }
    }
}
