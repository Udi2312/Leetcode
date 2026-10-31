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
    public TreeNode helper(int[] postorder , int polo, int pohi, int[] inorder, int inlo , int inhi){
        if(polo > pohi) return null;
        TreeNode root = new TreeNode(postorder[pohi]);
        int i = inlo;
        while(inorder[i] != postorder[pohi]) i++;
        int lz = i - inlo;
        int rz = inhi - i;
        root.left = helper(postorder , polo, polo + lz-1, inorder , inlo , i-1);
        root.right = helper(postorder , pohi - rz, pohi - 1, inorder , i+1 , inhi);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return helper(postorder , 0 , n-1, inorder , 0 , n-1);
    }
}