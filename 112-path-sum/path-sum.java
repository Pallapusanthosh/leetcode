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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return inorder(root,0,targetSum);
    }
    boolean inorder(TreeNode root,int sum,int target){
        if(root!=null)sum += root.val;
        if(sum == target && root.left == null && root.right == null){
            return true;
        }
        boolean lef = root.left!=null ? inorder(root.left,sum,target) : false;
        boolean rig = root.right!=null ? inorder(root.right,sum,target) : false;
        return  lef || rig;
    }
}