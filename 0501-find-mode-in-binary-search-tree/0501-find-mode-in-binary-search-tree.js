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
 * @return {number[]}
 */
var findMode = function(root) {
   let values = [];
    
    // Helper function to traverse the tree in inorder
    const inorder = (node) => {
        if (node === null) {
            return;
        }
        inorder(node.left); // Traverse left subtree
        values.push(node.val); // Add the value to the result
        inorder(node.right); // Traverse right subtree
    };
    
    inorder(root); // Perform in-order traversal

    let map = new Map();
    let max = 0;
    
    // Count the frequency of each value
    for (let val of values) {
        map.set(val, (map.get(val) || 0) + 1);
        max = Math.max(max, map.get(val));
    }

    // Collect values that appear the most frequently
    let result = [];
    for (let val of values) {
        if (map.get(val) === max && !result.includes(val)) {
            result.push(val);
        }
    }

    return result;
    
};