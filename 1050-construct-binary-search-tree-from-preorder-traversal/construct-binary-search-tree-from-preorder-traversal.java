class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, 0, preorder.length - 1);
    }
//the intution is since given preorder traversal 
    private TreeNode build(int[] pre, int start, int end) {
        if (start > end) return null; // base case

        TreeNode root = new TreeNode(pre[start]);

        // Find the first index where the value is greater than root's value
        int split = start + 1;
        while (split <= end && pre[split] < pre[start]) {
            split++;
        }

        // Left subtree: elements from start+1 to split-1
        root.left = build(pre, start + 1, split - 1);
        // Right subtree: elements from split to end
        root.right = build(pre, split, end);

        return root;
    }
}
