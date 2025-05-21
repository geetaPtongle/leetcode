class NodeValue {
    int mini;
    int maxi;
    int sum;

    NodeValue(int min, int max, int sum) {
        this.mini = min;
        this.maxi = max;
        this.sum = sum;
    }
}

class Solution {
    private int ans = 0; // Moved to class-level

    public int maxSumBST(TreeNode root) {
        helper(root);
        return ans;
    }

    private NodeValue helper(TreeNode root) {
        if (root == null)
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);

        // Check if the current subtree is a BST
        if (left.maxi < root.val && root.val < right.mini) {
            int totalSum = left.sum + right.sum + root.val;
            ans = Math.max(ans, totalSum);
            return new NodeValue(
                Math.min(left.mini, root.val),
                Math.max(root.val, right.maxi),
                totalSum
            );
        }

        // If not a BST, return values that prevent parents from being BST
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.sum, right.sum));
    }
}
