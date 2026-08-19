class Solution {
    int maxDiameter = 0;

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Diameter passing through current node
        int currentDiameter = leftHeight + rightHeight;

        // Take maximum among all nodes
        maxDiameter = Math.max(maxDiameter, currentDiameter);

        // Return height of current node
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDiameter;
    }
}