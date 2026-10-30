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
class BSTIterator {
    List<Integer> arr;
    int i;
    public void preorder(TreeNode root){
        if(root==null) return;
        preorder(root.left);
        arr.add(root.val);
        preorder(root.right);
    }
    public BSTIterator(TreeNode root) {
        arr = new ArrayList<>();
        i = 0;
        preorder(root);
    }
    
    public int next() {
        return arr.get(i++); 
    }
    
    public boolean hasNext() {
        if(i >= arr.size()) return false;
        else return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */