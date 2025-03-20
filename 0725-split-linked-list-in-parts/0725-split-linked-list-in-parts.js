/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode[]}
 */
var splitListToParts = function(head, k) {
    let count = 0, node = head;
    
    // Step 1: Count total nodes
    while (node) {
        count++;
        node = node.next;
    }

    let minSize = Math.floor(count / k); // Minimum nodes per part
    let extra = count % k; // Extra nodes to distribute
    let result = new Array(k).fill(null);
    node = head;

    // Step 2: Split into k parts
    for (let i = 0; i < k; i++) {
        if (!node) break; // No more nodes left

        result[i] = node;
        let partSize = minSize + (extra > 0 ? 1 : 0); // Assign extra node to first 'extra' parts
        extra--;

        // Move to the last node of the current part
        for (let j = 1; j < partSize; j++) {
            node = node.next;
        }

        // Disconnect the part
        let next = node.next;
        node.next = null;
        node = next;
    }

    return result;
};
