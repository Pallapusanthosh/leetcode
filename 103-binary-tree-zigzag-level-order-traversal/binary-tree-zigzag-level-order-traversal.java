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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean LefttoRight = true;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            ArrayList<Integer> levellist = new ArrayList<>();
            

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if(LefttoRight){
                    levellist.add(current.val);
                }else{
                    levellist.add(0,current.val);
                }
                 
        
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            LefttoRight = !LefttoRight;
          
            result.add(new ArrayList<>(levellist));
        }
        return result;
    }
}