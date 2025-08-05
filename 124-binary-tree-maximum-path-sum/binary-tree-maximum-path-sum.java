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
    public int maxPathSum(TreeNode root) {
        int maxi[] = new int[1];
        maxi[0] = Integer.MIN_VALUE;
        //refer height and diamter of a tree first 
        findpathmax(root,maxi);
        return maxi[0];
    }
    int findpathmax(TreeNode root , int[] maxi){
        if(root == null) return 0;
        int lh = Math.max(0,findpathmax(root.left,maxi));
        int rh = Math.max(0,findpathmax(root.right,maxi));
        maxi[0] = Math.max(maxi[0],lh+rh+root.val);//this is for getting a maxpathsum at a node
        return root.val + Math.max(lh,rh);//which ever gives the maximum sum we take that part of tree 
    }
}