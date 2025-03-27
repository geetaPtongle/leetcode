/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root1
 * @param {TreeNode} root2
 * @return {TreeNode}
 */
// var mergeTrees = function(root1, root2) {
//     if (!root1) return root2;  // If root1 is null, return root2
//     if (!root2) return root1;  // If root2 is null, return root1

//     // Create a new node with sum of both roots' values
//     let merged = new TreeNode(root1.val + root2.val);

//     // Recursively merge left and right subtrees
//     merged.left = mergeTrees(root1.left, root2.left);
//     merged.right = mergeTrees(root1.right, root2.right);

//     return merged;
// };

var mergeTrees = function(root1, root2) {
    if (!root1) return root2;
    if (!root2) return root1;

    let queue = [[root1, root2]];

    while (queue.length > 0) {
        let [node1, node2] = queue.shift();

        // Merge values
        node1.val += node2.val;

        // Process left children
        if (node1.left && node2.left) {
            queue.push([node1.left, node2.left]);
        } else if (!node1.left) {
            node1.left = node2.left; // Attach non-null node
        }

        // Process right children
        if (node1.right && node2.right) {
            queue.push([node1.right, node2.right]);
        } else if (!node1.right) {
            node1.right = node2.right; // Attach non-null node
        }
    }

    return root1;
};
