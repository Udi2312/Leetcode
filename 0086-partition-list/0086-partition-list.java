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
    public ListNode partition(ListNode head, int x) {
        Queue<Integer> greater = new LinkedList<>();
        Queue<Integer> less = new LinkedList<>();
        ListNode temp = head;
        while(temp != null){
            if(temp.val >= x) greater.add(temp.val);
            else less.add(temp.val);
            temp = temp.next;
        }
        temp = head;
        while(less.size() > 0){
            temp.val = less.remove();
            temp = temp.next;
        }
        while(greater.size() > 0){
            temp.val = greater.remove();
            temp = temp.next;
        }
        return head;
    }
}