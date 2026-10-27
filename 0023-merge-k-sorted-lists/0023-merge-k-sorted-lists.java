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
    class Pair implements Comparable<Pair>{
        int val;
        ListNode node;
        Pair(int val , ListNode node){
            this.val = val;
            this.node = node;
        }
        public int compareTo(Pair p){
            return Integer.compare(this.val, p.val);
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0; i<lists.length; i++){
        if(lists[i] == null) continue;
            pq.add(new Pair(lists[i].val, lists[i]));
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(pq.size() > 0){
            Pair front = pq.remove();
            temp.next = front.node;
            temp = temp.next;
            if(front.node.next != null) pq.add(new Pair(front.node.next.val,front.node.next));
        }
        return dummy.next;
    }
}