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
       int count =0;
    public int sumOfLeftLeaves(TreeNode root) {
        count =0;
        postOrder(root, 'c');
        return count;
    }

    public void postOrder(TreeNode curr, char dir){
        if(curr == null) return;
        if(curr.left == null && curr.right ==null && dir =='l'){
            count +=curr.val;
        }
        
        postOrder(curr.left , 'l');
        postOrder(curr.right, 'r');
    }
}