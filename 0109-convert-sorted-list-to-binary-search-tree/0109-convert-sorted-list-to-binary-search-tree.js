/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {ListNode} head
 * @return {TreeNode}
 */
var sortedListToBST = function (head) {
    if (head == null) return null;
    if (head.next == null) return new TreeNode(head.val);
    let slow_prev = null;
    let slow = head;
    let fast = head;
    while (fast !== null && fast.next !== null) {
        slow_prev = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    slow_prev.next = null;

    let root = new TreeNode(slow.val);
    root.left = sortedListToBST(head)
    root.right = sortedListToBST(slow.next);
    return root;
};