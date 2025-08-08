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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        return bst(root,val);
       
    }
    TreeNode bst(TreeNode root,int val){
        if(root==null)return null;
        // System.out.println(root.val);
        if(root.val == val){
            return root;
        }
        else if(root.val < val)return bst(root.right,val);
        else return bst(root.left,val);
    }
}