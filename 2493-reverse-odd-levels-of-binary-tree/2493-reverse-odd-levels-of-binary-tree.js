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

//  Time Complexity: O(N) → Every node is visited once.

// Space Complexity: O(N) → BFS queue + level-wise storage.
var reverseOddLevels = function (root) {
    if (!root) return null;
    let queue = [root];
    let level = 0;
    while (queue.length > 0) {  // O(N) - We process each node once
        let size = queue.length; // O(1) - Get level size
        let levelNodes = []; // O(1) - Store nodes for swapping

        for (let i = 0; i < size; i++) {  // O(N) - Traverse level nodes
            let node = queue.shift();  // O(1) - Remove from queue
            levelNodes.push(node);  // O(1) - Store node for reversing

            if (node.left) queue.push(node.left);  // O(1) - Push left child
            if (node.right) queue.push(node.right);  // O(1) - Push right child
        }

        if (level % 2 === 1) {  // Only reverse on odd levels
            let left = 0, right = levelNodes.length - 1;
            while (left < right) {  // O(K) - Reverse level values
                [levelNodes[left].val, levelNodes[right].val] =
                 [levelNodes[right].val, levelNodes[left].val];
                left++;
                right--;
            }
        }

        level++;  // Move to next level
    }
    return root;
};