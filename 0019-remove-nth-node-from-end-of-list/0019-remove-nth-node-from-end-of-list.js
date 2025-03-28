/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function (head, n) {
    let size = getLength(head);
    if (size == n) {
        let temp = head.next;
        delete head;
        return temp;
    }

    traverse_list = size - n;
    let temp = head;
    let prev = null;
    while (traverse_list--) {
        prev = temp;
        temp = temp.next;
    }
    prev.next=temp.next;
    delete temp;
    return head;
};


var getLength = function (head) {
    let count = 0;
    let current = head;

    while (current !== null) {
        count++;
        current = current.next; // Move to the next node
    }

    return count;
};