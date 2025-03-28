/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {boolean}
 */
//  Time Complexity	O(N)
/* This function uses Floyd’s Tortoise and Hare algorithm (two-pointer     technique).
*/
// Space Complexity	O(1)
/* The algorithm only uses two pointers (slow and fast) and 
*  a third pointer (p) for tracking the cycle's start.
*/

var hasCycle = function (head) {
    if (head == null) return false
    let slow = fast = head;
    while (fast && fast.next) {
        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast)
            return true;
    }
    return false;
};