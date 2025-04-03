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

//Approach-1 (Using O(n) space)
//T.C : O(n)
//S.C : O(n)
var inorderTraversal = function(root) {
   let result=[];
    
    // Helper function to traverse the tree in inorder
    const inorder = (node) => {
        if (node === null) {
            return;
        }
        inorder(node.left); // Traverse left subtree
        result.push(node.val); // Add the value to the result
        inorder(node.right); // Traverse right subtree
    };
    
  inorder(root); // Perform in-order traversal
return   result;
};

