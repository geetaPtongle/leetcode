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
 * @return {TreeNode}
 */
//TC:  O(n): We visit each node exactly once during the in-order traversal, where n is the number of nodes in the tree.
//SC:  O(h): The space complexity is the depth of the recursion stack, where h is the height of the tree (which in the worst case can be O(n) for an unbalanced tree).
var increasingBST = function(root) {
    let newTree = new TreeNode(0);  // Dummy node to act as the new tree's root
    let current = newTree;  // A pointer to build the new tree

    // In-order traversal function
    function inorder(node) {
        if (node === null) return;

        inorder(node.left);  // Traverse left subtree
        
        // Modify the current node
        node.left = null;  // Ensure the left child is null
        current.right = node;  // Append current node to the right
        current = current.right;  // Move to the right child of the new tree
        
        inorder(node.right);  // Traverse right subtree
    }

    inorder(root);  // Start the in-order traversal
    return newTree.right;  // Return the right child of dummy node (new tree's root)
};
