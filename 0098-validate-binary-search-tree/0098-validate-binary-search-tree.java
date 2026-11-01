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
    boolean flag;
    TreeNode prev;
    public void solve(TreeNode root){
        if(root ==null) return;
        solve(root.left);
        if(prev != null){
            if(prev.val >= root.val) flag = false;
        }
        prev = root;
        solve(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        flag = true;
        prev = null;
        solve(root);
        return flag;       
    }
}