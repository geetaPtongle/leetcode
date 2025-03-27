/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} original
 * @param {TreeNode} cloned
 * @param {TreeNode} target
 * @return {TreeNode}
 */
//TC: O(N)
//SC: O(H) (O(N) worst case) H = Height of the tree (O(log N) for balanced, O(N) for skewed trees).
var getTargetCopy = function(original, cloned, target) {
     if(original === null) return null;
     if(target === original ) return cloned;
       let leftNode= getTargetCopy(original.left, cloned.left, target);
        if(leftNode != null) return leftNode;
       let rightNode = getTargetCopy(original.right, cloned.right, target);
       if(rightNode != null) return rightNode     
};


