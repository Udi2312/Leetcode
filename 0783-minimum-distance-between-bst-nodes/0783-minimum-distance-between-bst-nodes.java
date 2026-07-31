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
    static int diff = Integer.MAX_VALUE;
    static TreeNode prev = null;
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if(prev==null) prev = root;
        else{
            diff = Math.min(diff,Math.abs(root.val-prev.val));
            prev = root;
        } 
        inorder(root.right);
    }
    public int minDiffInBST(TreeNode root) {
        diff=Integer.MAX_VALUE;
        prev=null;
        inorder(root);
        return diff;
    }
}