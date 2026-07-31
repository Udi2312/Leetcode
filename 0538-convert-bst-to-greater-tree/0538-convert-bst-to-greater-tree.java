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
    public void postorder(TreeNode root, int[] sum){
        if(root==null) return;
        postorder(root.right,sum);
        root.val += sum[0];
        sum[0] = root.val;
        postorder(root.left,sum);
    }
    public TreeNode convertBST(TreeNode root) {
        if(root==null) return null;
        int sum[] = new int[1];
        postorder(root,sum);
        return root;
    }
}