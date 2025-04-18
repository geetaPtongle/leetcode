/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {number[]} nums
 * @return {TreeNode}
 */
var sortedArrayToBST = function (nums) {
    function helper(l, r) {
        if (l > r) return null;

        let mid = Math.floor((l + r) / 2);
        let root = new TreeNode(nums[mid]);

        root.left = helper(l, mid - 1);
        root.right = helper(mid + 1, r);

        return root;
    }
    return helper(0, nums.length - 1)


};

