/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {ListNode}
 */

// Time Complexity: O(N)
// Space Complexity: O(1)
var detectCycle = function (head) {
    if (!head || !(head.next)) return null;
    let slow = fast = head;
    while (fast && fast.next) {
        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast)
            break;
    }
    if (fast != slow)
        return null;
        
    slow = head;
    while (slow != fast) {
        slow = slow.next;
        fast = fast.next;
    }
    return slow;
};