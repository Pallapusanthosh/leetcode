class Solution {
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> memo = new HashMap<>();
        return robSubtree(root, memo);
    }

    private int robSubtree(TreeNode node, Map<TreeNode, Integer> memo) {
        if (node == null) return 0;
        if (memo.containsKey(node)) return memo.get(node);

        // Rob this node
        int rob = node.val;
        if (node.left != null) {
            rob += robSubtree(node.left.left, memo);
            rob += robSubtree(node.left.right, memo);
        }
        if (node.right != null) {
            rob += robSubtree(node.right.left, memo);
            rob += robSubtree(node.right.right, memo);
        }

        // Don't rob this node
        int notRob = robSubtree(node.left, memo) + robSubtree(node.right, memo);

        int result = Math.max(rob, notRob);
        memo.put(node, result);
        return result;
    }
}
