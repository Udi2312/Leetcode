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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> one = new Stack<>();
        Stack<Integer> two = new Stack<>();
        while(l1 != null){
            one.add(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            two.add(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        int sum = 0;
        ListNode ans = new ListNode(0);
        while(one.size() > 0 || two.size() > 0){
            if(one.size() > 0){
                sum += one.pop();
            }
            if(two.size() > 0){
                sum += two.pop();
            }
            ans.val = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(carry);
            newNode.next = ans;
            ans = newNode;
            sum = carry;
        }
        if(ans.val != 0) return ans;
        return ans.next;
    }
}