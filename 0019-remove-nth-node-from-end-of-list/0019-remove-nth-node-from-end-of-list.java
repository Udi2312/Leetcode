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
    int curr = -1;
    public void helper(ListNode head, int n){
        if(head == null){
            return;
        }
        helper(head.next,n);
        curr++;
        if(curr == n){
            head.next = head.next.next;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;
        ListNode l = new ListNode(-1);
        l.next = head;
        helper(l , n);
        return l.next;
    }
}