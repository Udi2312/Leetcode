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
    public void recoverTree(TreeNode root) {
        TreeNode curr = root;
        TreeNode prev = null;
        TreeNode pprev = null;
        List<TreeNode> arr = new ArrayList<>();
        while(curr!=null){
                TreeNode pred = curr.left;
            if(curr.left != null){
                while(pred.right!=null && pred.right!=curr) pred = pred.right;
                if(pred.right == null){
                    pred.right = curr;
                    curr = curr.left;
                }
                if(pred.right==curr){
                    pred.right = null;
                    if(prev != null && pprev != null){
                        if(prev.val>curr.val && prev.val > pprev.val) arr.add(prev);
                        if(prev.val<curr.val && prev.val < pprev.val) arr.add(prev);
                    }
                    else if(prev != null && prev.val > curr.val) arr.add(prev);
                    pprev = prev;
                    prev = curr;
                    curr = curr.right; 
                }
            }
            else{
                // pred.right = null;
                if(prev != null && pprev != null){
                    if(prev.val>curr.val && prev.val > pprev.val) arr.add(prev);
                    if(prev.val<curr.val && prev.val < pprev.val) arr.add(prev);
                }
                else if(prev != null && prev.val > curr.val) arr.add(prev);
                pprev = prev;
                prev = curr;
                curr = curr.right; 
            }
        }
        if(prev.val<pprev.val) arr.add(prev);
        TreeNode f = arr.get(0);
        TreeNode s = arr.get(arr.size()-1);
        int temp = f.val;
        f.val = s.val;
        s.val = temp;
    }
}