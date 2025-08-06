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
        System.out.println(root);
        return dfs(root,p,q); 
    }
    TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
        
        if(root == p) return root;
        if(root == q) return root;
        if(root.left== null && root.right == null) return null;
        TreeNode lefttree  = root.left!=null ? dfs(root.left,p,q): null;
        TreeNode righttree = root.right!=null ?dfs(root.right,p,q):null;
        if(lefttree!=null && righttree!=null) return root;
        if (lefttree == null && righttree == null) return null;
        return (lefttree != null) ? lefttree : righttree;

    }
}