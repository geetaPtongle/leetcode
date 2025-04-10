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
    public int sumNumbers(TreeNode root) {
        return solve(root, 0);
    }

    public int solve(TreeNode node, int curr) {
        if (node == null)
            return 0;

         curr = curr * 10 + node.val;

        if (node.left == null && node.right ==null) {
            return curr;
        }

        int left_num = solve(node.left, curr);
        int right_num = solve(node.right, curr);

        return left_num + right_num;
    }
}