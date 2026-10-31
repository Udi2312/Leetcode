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
    class Pair{
        TreeNode node;
        int l;
        Pair(TreeNode node, int l){
            this.node = node;
            this.l = l;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        q.add(new Pair(root , 0));
        while(q.size() > 0){
            Pair front = q.remove();
            if(list.size() <= front.l){
                list.add(new ArrayList<>());
                list.get(front.l).add(front.node.val);
               if(front.node.left != null) q.add(new Pair(front.node.left, front.l+1));
               if(front.node.right != null) q.add(new Pair(front.node.right, front.l+1));
            }
            else{
                 list.get(front.l).add(front.node.val);
               if(front.node.left != null) q.add(new Pair(front.node.left, front.l+1));
               if(front.node.right != null) q.add(new Pair(front.node.right, front.l+1));
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(List<Integer> li : list){
            ans.add(li.get(li.size()-1));
            for(int e : li) System.out.print(e + " ");
            System.out.println();
        }
        return ans;
    }
}