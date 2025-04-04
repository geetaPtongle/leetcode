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
 * @param {number} targetSum
 * @return {number[][]}
 */
var pathSum = function(root, targetSum) {
    const result = [];
    const temp = [];
    
    // Inner function to collect paths
    function collectPaths(root, curr, temp, result) {
        if (root === null) return;

        temp.push(root.val);

        if (root.left === null && root.right === null && root.val === curr) {
            result.push([...temp]);  // Create a new array to avoid reference issues
        }

        collectPaths(root.left, curr - root.val, temp, result);
        collectPaths(root.right, curr - root.val, temp, result);

        temp.pop();  // Removes the last element from the temp array
    }

    // Call the inner function
    collectPaths(root, targetSum, temp, result);
    
    return result;
};