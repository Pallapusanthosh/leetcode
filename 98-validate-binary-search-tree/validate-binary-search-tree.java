class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean[] ans = { true };
        check(root, Long.MIN_VALUE, Long.MAX_VALUE, ans);
        return ans[0];
    }

    void check(TreeNode root, long low, long high, boolean[] ans) {
        if (root == null || !ans[0]) return;

        if (root.val <= low || root.val >= high) {
            ans[0] = false;
            return;
        }

        check(root.left, low, root.val, ans);
        check(root.right, root.val, high, ans);
    }
}
