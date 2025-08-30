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
    //makeing use of bst means a take an ele and found it diff and search for the diff in the bst searching in bst takes o(h) logn t is helpful and there is no extra space too
    return dfs(root,root,k);

    }
    boolean dfs(TreeNode curnode , TreeNode root, int k){
        if(curnode==null)return false; 
        int diff = k - curnode.val;
        int curval = curnode.val;
        if(diff!=curval && search(root,diff))return true;

        return dfs(curnode.left,root,k) || dfs(curnode.right,root,k);
        
        
    }
    boolean search(TreeNode root,int diff){
        while(root!=null){
            if(root.val == diff){
                return true;
            }
            else if(root.val < diff){
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
        return false;
    }
}




 //     //idea is to do inordertraversal if we already found k-cur root then it is true;
    //     HashSet<Integer> set = new HashSet<>();
    //     boolean[] ans = new boolean[] {false};
    //     // ans[0] = false;
    //     inorder(root,k,set,ans);
    //     return ans[0];
    // }
    // void inorder(TreeNode root , int k,HashSet<Integer> set,boolean[] ans){
    //     if(root == null)return;
    //     if(ans[0]) return;

    //     inorder(root.left,k,set,ans);
    //     if(set.contains(root.val)){
    //         ans[0] = true;
    //         return;
    //     }
    //     set.add(k - root.val);
    //     inorder(root.right,k,set,ans);