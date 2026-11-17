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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode helper(int[] arr , int l , int r){
        if(l>r) return null;
        int mid = (l+r)/2;
        TreeNode n = new TreeNode(arr[mid]);
        n.left = helper(arr,l,mid-1);
        n.right = helper(arr,mid+1,r);
        return n;
    }
    public TreeNode sortedListToBST(ListNode head) {
        ListNode temp = head;
        int n = 0;
        while(temp != null){
            n++;
            temp = temp.next;
        }
        int arr[] = new int[n];
        temp = head;
        int k = 0;
        while(temp != null){
            arr[k++] = temp.val;
            temp = temp.next;
        }
        return helper(arr,0,n-1);
    }
}