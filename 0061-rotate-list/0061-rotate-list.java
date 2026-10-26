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
        if(head == null) return null;
        ListNode temp = head;
        int n = 0;
        while(temp != null){
            temp = temp.next;
            n++;
        }
        k = k % n;
        if(k == 0) return head;
        temp = head;
        for(int i = 0; i<n-1; i++){
            temp = temp.next;
        }
        temp.next = head;
        temp = head;
        for(int i = 0; i<n-1-k; i++){
            temp = temp.next;
        }
        ListNode ans = temp.next;
        temp.next = null;
        return ans;
    }
}