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
    List<List<Integer>> ans = new ArrayList<>();
    public int height(TreeNode root){
        if(root==null || (root.left==null && root.right==null)) return 0;
        return 1 + Math.max(height(root.left) , height(root.right));
    }
    public void nthlevel(TreeNode root, int n, List<Integer> curr){
        // List<Integer> curr = new ArrayList<>();
        if(root==null) return;
        if(n==1){
            curr.add(root.val);
            return;
        }
        nthlevel(root.left,n-1,curr);
        nthlevel(root.right,n-1,curr);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        int level = height(root) + 1;
        if(root==null) return ans;
        for(int i = 1; i<=level; i++){
        List<Integer> curr = new ArrayList<>();
            nthlevel(root,i,curr);
            ans.add(curr);
        }
        return ans;
    }
    }