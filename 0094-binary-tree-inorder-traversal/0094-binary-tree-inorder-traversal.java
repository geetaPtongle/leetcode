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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>() ;
        inOrder(root, result);
        return result;        
    }

    public void inOrder(TreeNode curr,  List<Integer> result){
        if(curr == null) return;
        inOrder(curr.left,result );
        result.add(curr.val);
        inOrder(curr.right,result );
    }
}