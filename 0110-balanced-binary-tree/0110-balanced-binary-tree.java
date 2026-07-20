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
     public int height(TreeNode root){
        if(root == null || (root.left == null && root.right==null)) return 0;
        return 1+ Math.max(height(root.left) , height(root.right));
     }
    public boolean isBalanced(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return true;
        boolean one = isBalanced(root.left);
        boolean two = isBalanced(root.right);
        int left = height(root.left);
        if(root.left != null) left++;
        int right = height(root.right);
        if(root.right != null) right++;
        if(Math.abs(right-left) <= 1) return one && two;
        else return false;
    }
}