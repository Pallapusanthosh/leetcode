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
    public int countNodes(TreeNode root) {
        //to solve this you need a complete binary tree fully filled 
        //check for fully filled if not treat it as a subtree
        // int count = 0;
        return counter(root);
    }
    int counter(TreeNode root){
        if(root == null) return 0;
       
        int lh = leftHeight(root);
        int rh = rightHeight(root);
        if(lh == rh){
            return (int)Math.pow(2, lh) - 1;
        }
      
        return 1 + counter(root.left) + counter(root.right);
    }
    int leftHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height;
   }
    int rightHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.right;
        }
        return height;
    }
}