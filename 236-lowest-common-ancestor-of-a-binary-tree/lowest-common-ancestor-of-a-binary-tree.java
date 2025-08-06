/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root,p,q); 
    }
    TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
        
        if(root == p) return root;
        if(root == q) return root;
        //check the current node is equal to p or q;
        if(root.left== null && root.right == null) return null;
        //leaf case
        TreeNode lefttree  = root.left!=null ? dfs(root.left,p,q): null;
        TreeNode righttree = root.right!=null ?dfs(root.right,p,q):null;

        if(lefttree!=null && righttree!=null) return root;
        //if both nodes are null return null
        if (lefttree == null && righttree == null) return null;
        // at last means one of the node is not null so return that one 
        return (lefttree != null) ? lefttree : righttree;

    }
}