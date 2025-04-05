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
var minDiffInBST = function(root) {
    minDiff = Infinity;
    prev =null;
    inorder(root);
    return minDiff;
};

function inorder(node){
    if(node ==null) return null;
    inorder(node.left);
    if(prev !=null){
        minDiff= Math.min(minDiff, node.val- prev.val)
    }
    prev =node;
    inorder(node.right);
    
}