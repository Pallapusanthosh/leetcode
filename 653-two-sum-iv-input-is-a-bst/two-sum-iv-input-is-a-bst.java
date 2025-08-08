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
    public boolean findTarget(TreeNode root, int k) {
        //idea is to do inordertraversal if we already found k-cur root then it is true;
        HashSet<Integer> set = new HashSet<>();
        boolean[] ans = new boolean[] {false};
        // ans[0] = false;
        inorder(root,k,set,ans);
        return ans[0];
    }
    void inorder(TreeNode root , int k,HashSet<Integer> set,boolean[] ans){
        if(root == null)return;

        inorder(root.left,k,set,ans);
        if(set.contains(root.val)){
            ans[0] = true;
        }
        set.add(k - root.val);
        inorder(root.right,k,set,ans);
    }
}