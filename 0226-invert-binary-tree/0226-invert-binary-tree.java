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
// TC : O(n), where n is the number of nodes in the binary tree.
// SC : In the worst case (skewed tree), the depth of recursion is O(n).
// In the best case (balanced tree), it's O(log n).
class Solution {
    public TreeNode invertTree1(TreeNode root) {
        if (root == null)
            return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.offer(root);
        while (!qu.isEmpty()) {
            TreeNode curr = qu.poll();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            if (curr.left != null)
                qu.offer(curr.left);
            if (curr.right != null)
                qu.offer(curr.right);
        }
        return root;
    }

     public TreeNode invertTree(TreeNode root) {
            if (root == null)
            return null;
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.add(root);
        while(!st.isEmpty()){
            TreeNode curr=st.pop();
            TreeNode temp = curr.left;
            curr.left=curr.right;
            curr.right=temp;

            if(curr.left !=null) st.add(curr.left);
            if(curr.right !=null) st.add(curr.right);
        }
        return root;
     }
}