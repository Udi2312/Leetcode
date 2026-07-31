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
    public TreeNode construct(int[] nums, int l, int h){
        if(l>h) return null;
        int mid = (l+h)/2;
        TreeNode a = new TreeNode(nums[mid]);
        a.left = construct(nums, l , mid-1);
        a.right = construct(nums, mid+1 , h);
        return a;
    }
    public TreeNode sortedListToBST(ListNode head) {
        ListNode temp = head;
        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        int ans[] = new int[len];
        temp = head;
       for(int i = 0; i<len; i++){
        ans[i] = temp.val;
        temp = temp.next;
       }
       Arrays.sort(ans);
       return construct(ans,0,ans.length-1);
    }
}