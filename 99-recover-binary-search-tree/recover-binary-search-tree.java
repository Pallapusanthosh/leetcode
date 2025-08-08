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
    TreeNode prev = null, prev1 = null, mid = null, prev2 = null;
    public void recoverTree(TreeNode root) {
     //findout the nodes that are swapped and then swap them simple
     //inorder we get sory we know that 
     //in this case the inorder travesal is not sorted exatcly 2 places misplaced so check for them
     
     inorder(root);  
    
     if(prev2 == null) swap(prev1,mid);
     else swap(prev1,prev2);
     
    }
   
    void swap(TreeNode x , TreeNode y){
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
    void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        // Check for violation
        if (prev != null && prev.val > root.val) {
            if (prev1 == null) { // first violation
                prev1 = prev;
                mid = root;
            } else { // second violation
                prev2 = root;
            }
        }

        prev = root; // move forward in inorder

        inorder(root.right);
    }
}
