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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return pathSum(root, targetSum, 0);
    }

    public boolean pathSum(TreeNode root, int sum, int curr) {
        if (root == null) return false;

        // If it's a leaf node
        if (root.left == null && root.right == null) {
            return (curr + root.val == sum);
        }

        // Recursively check left and right subtrees
        boolean left = pathSum(root.left, sum, curr + root.val);
        boolean right = pathSum(root.right, sum, curr + root.val);

        return left || right;
    }

 }
    
