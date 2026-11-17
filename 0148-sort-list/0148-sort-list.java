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
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode d = new ListNode(-1);
        ListNode temp = d;
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        if(head1==null){
            while(head2 != null){
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        if(head2==null){
            while(head1 != null){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
        }
        return d.next;
    }
    public ListNode mergeSort(ListNode head, ListNode tail){
        if(head == null || head == tail) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode a = slow.next;
        slow.next = null;
        ListNode head1 = mergeSort(head,slow);
        ListNode head2 = mergeSort(a,tail);
        return merge(head1,head2);
    }
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        ListNode tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        return mergeSort(head,tail);
    }
}
