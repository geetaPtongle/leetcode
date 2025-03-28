/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {number}
 */

//  Time Complexity: O(n), since we traverse the list once.
// Space Complexity: O(1), since we use only a single integer variable
var getDecimalValue = function(head) {
    let num = 0;
    
    while (head !== null) {
        num = (num << 1) | head.val; // Left shift and add current value
        head = head.next; // Move to the next node
    }

    return num;
};

// Time Complexity: O(n), since we traverse the list once.
// Space Complexity: O(1), since we use only a single integer variable.
var getDecimalValue = function(head) {
    let binaryStr = "";
    
    while (head !== null) {
        binaryStr += head.val; // Concatenate each bit
        head = head.next;
    }

    return parseInt(binaryStr, 2); // Convert binary string to decimal
};
