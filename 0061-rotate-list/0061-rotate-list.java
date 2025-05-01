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
    public ListNode rotateRight(ListNode head, int k) {
        if(head ==null || head.next == null) return head;
        int n;
        ListNode tail =head;
        for( n=1; tail.next != null; n++){
            tail = tail.next;
        }
        tail.next=head;
        k %=n;
        ListNode new_head=head, new_tail=head;
        for(int i=1; i<n-k;i++){
            new_tail=new_tail.next;
        }
        new_head=new_tail.next;
        new_tail.next=null;
        return new_head;
    }

}