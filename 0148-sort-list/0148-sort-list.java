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
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode h = sortList(head.next);
        int v = head.val;
        ListNode temp = h;
        if(temp.val > v){
            head.next = h;
            return head;
        }
        while(temp.next != null && temp.next.val < v){
            temp = temp.next;
        }
        ListNode t2 = temp.next;
        temp.next = head;
        head.next = t2;
        return h;
    }
}