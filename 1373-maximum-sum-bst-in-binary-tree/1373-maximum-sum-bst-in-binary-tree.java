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

    int ans = 0;

    class NodeInfo {

        boolean isBST;
        int min;
        int max;
        int sum;

        NodeInfo(boolean isBST, int min, int max, int sum) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    public NodeInfo helper(TreeNode root) {

        if (root == null) {
            return new NodeInfo(true, Integer.MAX_VALUE,
                    Integer.MIN_VALUE, 0);
        }

        NodeInfo left = helper(root.left);
        NodeInfo right = helper(root.right);

        if (left.isBST && right.isBST &&
                root.val > left.max &&
                root.val < right.min) {

            int sum = left.sum + right.sum + root.val;

            ans = Math.max(ans, sum);

            int mn = Math.min(root.val, left.min);
            int mx = Math.max(root.val, right.max);

            return new NodeInfo(true, mn, mx, sum);
        }

        return new NodeInfo(false, 0, 0, 0);
    }

    public int maxSumBST(TreeNode root) {

        helper(root);

        return ans;
    }
}