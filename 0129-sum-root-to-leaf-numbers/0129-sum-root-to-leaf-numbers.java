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
    int ans;
    public void inorder(TreeNode root, List<Integer> curr){
        if(root == null) return;
        curr.add(root.val);
        if(root.left == null && root.right == null){
            int num = 0;
            for(int a : curr){
                num = num * 10 + a;
            }
            ans += num;
        }
        inorder(root.left,curr);
        inorder(root.right,curr);
        curr.remove(curr.size()-1);
    }
    public int sumNumbers(TreeNode root) {
        ans = 0;
        inorder(root,new ArrayList<>());
        return ans;
    }
}