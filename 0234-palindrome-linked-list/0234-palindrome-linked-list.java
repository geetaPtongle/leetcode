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
    //Approch one using Collections.resverse method 
    public boolean isPalindrome1(ListNode head) {
        List<Integer> list1 = new ArrayList<>();

        ListNode current = head;
        while (current != null) {
            list1.add(current.val);
            current = current.next;
        }
        List<Integer> list2 = new ArrayList<>(list1);
        Collections.reverse(list2);
        return list1.equals(list2);
    }

public boolean isPalindrome(ListNode head) {
    Stack<Integer> st=new Stack();
    ListNode current = head;
    while(current != null){
    st.push(current.val);
    current =current.next;
    }

    current =head;
    while(current != null){
        if( st.peek() != current.val){
            return false;
        } 
        else {
        current =current.next;
        st.pop();
        }
    } 
    return true;

}



}