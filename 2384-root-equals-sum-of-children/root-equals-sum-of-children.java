/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean checkTree(TreeNode root) {
        boolean[] ans = new boolean[1];
        ans[0] = true;
        inorder(root,ans);
        return ans[0];
    }
    void inorder(TreeNode root,boolean[] ans){
        if(root == null) return;
        if(root.left!=null && root.right!=null &&root.left.val + root.right.val != root.val){
            ans[0] = false;
        }
        inorder(root.left,ans);
        inorder(root.right,ans);
        
    }
}
