class Solution {
    public int helper(TreeNode root, long targetSum){
        if(root==null) return 0;
        int count = 0;
        if((long)root.val == targetSum) count++;
        return count + helper(root.left, targetSum-root.val) + helper(root.right, targetSum-root.val);
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        int count = helper(root,(long)targetSum);
        count += (pathSum(root.left, targetSum) + pathSum(root.right , targetSum));
        return count;
    }
}