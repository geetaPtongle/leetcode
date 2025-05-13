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
    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int resultLevel = 0;
        Queue<TreeNode> qe = new LinkedList<>();
        qe.offer(root);
        int currLevel=1;
        while (!qe.isEmpty()) {
            int size=qe.size();
            int sum =0;
            for(int i=0; i<size; i++){
                TreeNode curr = qe.poll();
                 sum+= curr.val;
                if (curr.left != null) {
                    qe.offer(curr.left);
                }
                if (curr.right != null) {
                    qe.offer(curr.right);
                }
            }
             if(sum > maxSum) {
                maxSum = sum;
                resultLevel = currLevel;
            }
            currLevel++;
            }
        return resultLevel;
        }
}