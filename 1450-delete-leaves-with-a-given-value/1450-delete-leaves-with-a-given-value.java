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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null)
            return null;

        TreeNode leftTree = removeLeafNodes(root.left, target);
        TreeNode rightTree = removeLeafNodes(root.right, target);

        root.left = leftTree; //suppose we make any refernece null so attaching that reference back to parrent node
        root.right = rightTree;

        if (leftTree == null && rightTree == null && root.val == target) { //leaf nodes are null and node value is equal to target value
            return null;
        }

        return root;
    }
}