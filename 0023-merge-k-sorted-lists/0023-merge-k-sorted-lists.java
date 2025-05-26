/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //Using Priorityqueue Approch
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));
        for(ListNode node : lists){
            if(node !=null)
            pq.offer(node);
        }
        ListNode head =null;
        ListNode temp =null;

        while(!pq.isEmpty()){
            ListNode curr= pq.poll();
            if(head ==null){
                head =curr;
                temp =curr;
            }
            else{
                temp.next=curr;
                temp=curr;
            }
            if(curr.next !=null){
                pq.offer(curr.next);
            }
        }
        return head;
    }

//Using Divide and conquer approch
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 != null) curr.next = l1;
        else curr.next = l2;

        return dummy.next;
    }
}