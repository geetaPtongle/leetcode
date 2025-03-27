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

//  1️⃣ Recursive DFS (Preorder - Most Common & Optimal)
// Time Complexity: O(N) → Visits every node once.

// Space Complexity: O(H) → Recursive call stack (H = height of tree).
// var invertTree = function(root) {
//     if (root === null) return null; // Base case

//     // Swap left and right subtrees
//     let temp = root.left;
//     root.left = root.right;
//     root.right = temp;

//     // Recursively invert left and right subtrees
//     invertTree(root.left);
//     invertTree(root.right);

//     return root;
// };

var invertTree = function(root) {
 if (!root) return null;
    let stack=[root];
    while(stack.length > 0){
        let node=stack.pop();

        [node.left, node.right]=[node.right, node.left];
          if(node.left !=null) stack.push(node.left);
        if(node.right !=null) stack.push(node.right);
    }
    return root;
}

// 3️⃣ BFS (Using Queue - Level Order)
// Time Complexity: O(N) → Visits every node once.
// Space Complexity: O(W) → Stores W nodes (W = max width of tree).
// var invertTree = function(root) {
//  if (!root) return null;
//     let queue = [root];
//     while(queue.length > 0){
//         let node =queue.shift();
//        [node.left, node.right] = [node.right, node.left];

//         if(node.left !=null) queue.push(node.left);
//         if(node.right !=null) queue.push(node.right);
//     }
//     return root
// }
