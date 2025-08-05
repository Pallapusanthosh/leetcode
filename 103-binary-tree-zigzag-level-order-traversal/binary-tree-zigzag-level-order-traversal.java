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
            // List<Integer> levelList = new ArrayList<>();
            int[] levellist = new int[levelSize];

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                int index = LefttoRight ? i : levelSize - 1 - i;
                levellist[index] = current.val;
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            LefttoRight = !LefttoRight;
            ArrayList<Integer> list = new ArrayList<>();
            for(int num : levellist){
                list.add(num);
            }
            result.add(new ArrayList<>(list));
        }
        return result;
    }
}