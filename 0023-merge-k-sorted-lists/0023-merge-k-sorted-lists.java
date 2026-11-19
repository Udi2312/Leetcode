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
    public ListNode helper(ListNode[] lists , int l, int r){
        if(l==r) return lists[l];
        int mid = l + (r-l)/2;
        ListNode left = helper(lists,l,mid);
        ListNode right = helper(lists,mid+1,r);
        return merge(left,right);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return helper(lists , 0, lists.length-1);
    }
}