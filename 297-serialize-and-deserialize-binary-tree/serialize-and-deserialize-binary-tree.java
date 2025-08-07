/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //use levelorder to build string
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            
            //empty the queue
            TreeNode qroot = q.poll();
            if(qroot== null){
                sb.append("#,");
            }else{
                sb.append(qroot.val + ",");
            }
            if(qroot!=null){
                q.offer(qroot.left);
                q.offer(qroot.right);
            }  
        }
    
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
   public TreeNode deserialize(String data) {
    if (data == null || data.length() == 0 || data.charAt(0) == '#') return null;

    String[] nodes = data.split(",");
    Queue<TreeNode> q = new LinkedList<>();
    int index = 0;

    TreeNode root = new TreeNode(Integer.parseInt(nodes[index++]));
    q.offer(root);

    while (!q.isEmpty()) {
        TreeNode current = q.poll();

        // Left child
        if (index < nodes.length) {
            String leftVal = nodes[index++];
            if (!leftVal.equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(leftVal));
                current.left = left;
                q.offer(left);
            }
        }

        // Right child
        if (index < nodes.length) {
            String rightVal = nodes[index++];
            if (!rightVal.equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(rightVal));
                current.right = right;
                q.offer(right);
            }
        }
    }

    return root;
}

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));