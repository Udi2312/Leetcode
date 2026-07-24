class Solution {
    public TreeNode helper(int[] preorder, int prelo, int prehi, int[] inorder, int inlo, int inhi){
        if(prelo>prehi) return null;
       TreeNode root = new TreeNode(preorder[prelo]);
       int i = inlo;
       while(inorder[i] != preorder[prelo]) i++;
       int left = i-inlo;
    //    int right = inhi-i-1;
       root.left = helper(preorder,prelo+1,prelo+left,inorder,inlo,i-1);
       root.right = helper(preorder,prelo+left+1,prehi,inorder,i+1,inhi);
       return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
}