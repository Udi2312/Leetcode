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
    public ListNode rev(ListNode head, int right){
        if(right == 0){
            // head = head.next;
            return head;
        }
        ListNode ans = rev(head.next, right-1);
        head.next.next = head;
        head.next = null;
        return ans;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null) return head;
        if(left == right) return head;
        ListNode l = new ListNode(-1);
        l.next = head;
        ListNode temp = head;
        ListNode prev = l;
        for(int i = 0; i<left-1; i++){
            temp = temp.next;
            prev = prev.next;
        }
        ListNode fut = head;
        for(int i = 0; i<right; i++){
            fut = fut.next;
        }
        prev.next = rev(temp , right-left);
        temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = fut;
        return l.next;
    }
}