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
        TreeNode ans = new TreeNode(0);
        dfs(root,p,q,ans);
        // System.out.print(ans.val);
        return ans;
    }
    void dfs(TreeNode root, TreeNode p, TreeNode q,TreeNode ans){
        if(ans == null) return;
        if(root==null) return;
        int curval = root.val;
          //left and right 
        if(curval == p.val){
            ans.val = curval;
            return;
        }
        if(curval == q.val){
            ans.val = curval;
            return;
        }
        if((curval > p.val && curval < q.val)||(curval > q.val && curval < p.val)){
            ans.val = root.val;
            return;
        }
        //only left
        if(curval > p.val && curval > q.val){
            dfs(root.left,p,q,ans);
        }else{
            dfs(root.right,p,q,ans);
        }
    }
}