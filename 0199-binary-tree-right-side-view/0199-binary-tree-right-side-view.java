class Solution {
    List<Integer> ans = new ArrayList<>();
    public void helper(TreeNode root, int level){
        if(root==null) return;
        if(level == ans.size()) ans.add(root.val);
        helper(root.right,level+1);
        helper(root.left,level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        helper(root,0);
        return ans;
    }
}