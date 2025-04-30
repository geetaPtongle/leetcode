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
    public boolean isPalindrome(ListNode head) {
        List<Integer> list1 =new ArrayList<>();
        
        ListNode current =head;
        while(current !=null){
            list1.add(current.val);
            current=current.next;
        }
        List<Integer> list2 =new ArrayList<>(list1);
        Collections.reverse(list2);
        return list1.equals(list2);
    }
}