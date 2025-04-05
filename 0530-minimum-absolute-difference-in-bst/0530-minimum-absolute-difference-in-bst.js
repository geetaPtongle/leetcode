/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */


function inOrder(root) {
    if (root === null) return;

    inOrder(root.left);

    if (prev !== null) {
        minDiff = Math.min(minDiff, root.val - prev.val);
    }

    prev = root;

    inOrder(root.right);
     return minDiff;
};


function getMinimumDifference(root) {
    minDiff = Infinity;
    prev = null;
    inOrder(root);
    return minDiff;
}