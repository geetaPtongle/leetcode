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
    int ans = 0;

    public int maxPathSum(TreeNode root) {
        ans = root.val;
        solve(root);
        return ans;
    }

    public int solve(TreeNode curr) {
        if (curr == null) return 0;
        int leftSum = Math.max(0, solve(curr.left));
        int rightSum = Math.max(0, solve(curr.right));
        ans = Math.max(ans, curr.val + leftSum + rightSum);
        return  curr.val + Math.max(leftSum , rightSum);
    }
}