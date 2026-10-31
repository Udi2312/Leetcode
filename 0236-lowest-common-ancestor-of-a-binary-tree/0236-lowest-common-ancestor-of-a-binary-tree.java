/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean search(TreeNode root, TreeNode p){
        if(root==null) return false;
        if(root == p) return true;
        else return search(root.left,p) || search(root.right,p);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if (root == p || root == q) return root;
        if((search(root.left,p) && search(root.right,q)) || (search(root.left,q) && search(root.right,p))) return root;
        else{
            TreeNode l = lowestCommonAncestor(root.left,p,q);
            TreeNode r = lowestCommonAncestor(root.right,p,q);
            if(l != null) return l;
            return r;
        }
    }
}