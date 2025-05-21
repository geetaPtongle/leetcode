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
     List<Integer> inorderList = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        boolean[] ans=new boolean[]{true};
        TreeNode[] prev = new TreeNode[1];
     inorderTraversal(root, prev, ans);
     return ans[0];
    }

    public void inorderTraversal(TreeNode root,TreeNode[] prev, boolean[] ans){
        if(root==null) return;
        inorderTraversal(root.left, prev, ans);
        if(prev[0] != null){
            if(prev[0].val >= root.val) {
                ans[0]=false;
                  return;
                }          
        }
        prev[0]=root;
        inorderTraversal(root.right,prev, ans);
    }
}