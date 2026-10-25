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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode l = new ListNode(-101);
        ListNode temp = l;
        l.next = head;
        HashSet<Integer> st = new HashSet<>();
        while(temp != null && temp.next != null){
            if(temp.next.val != temp.val){
                temp = temp.next;
                continue;
            }
            else{
                st.add(temp.val);
                while(temp.next != null && temp.val == temp.next.val){
                temp.next = temp.next.next;
                }
                temp = temp.next;
            }
        }
        temp = l;
        while(temp != null && temp.next != null){
            while(temp.next != null && st.contains(temp.next.val)){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return l.next;
    }
}