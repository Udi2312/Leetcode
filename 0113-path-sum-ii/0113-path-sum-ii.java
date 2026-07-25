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
    public void helper(List<List<Integer>> ans, List<Integer> arr, TreeNode root, int targetSum){
        if(root==null) return;
        if(root!=null && root.left == null && root.right==null){
                arr.add(root.val);
            if(root.val == targetSum){
                ans.add(new ArrayList<>(arr));
            }
                arr.remove(arr.size()-1);
                return;
            // else return;
        }
        arr.add(root.val);
        helper(ans,arr,root.left,targetSum-root.val);
        helper(ans,arr,root.right,targetSum-root.val);
        arr.remove(arr.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        helper(ans,arr,root,targetSum);
        return ans;
    }
}