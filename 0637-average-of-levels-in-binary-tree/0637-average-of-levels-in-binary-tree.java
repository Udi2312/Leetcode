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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        List<List<Integer>> arr = new ArrayList<>();

        q.add(new Pair(root , 0));
        while(q.size() > 0){
            Pair front = q.remove();
            if(arr.size() <= front.l){
                arr.add(new ArrayList<>());
                arr.get(front.l).add(front.node.val);
               if(front.node.left != null) q.add(new Pair(front.node.left, front.l + 1));
               if(front.node.right != null) q.add(new Pair(front.node.right , front.l + 1));
            }
            else{
                 arr.get(front.l).add(front.node.val);
               if(front.node.left != null) q.add(new Pair(front.node.left, front.l + 1));
               if(front.node.right != null) q.add(new Pair(front.node.right , front.l + 1));
            }
        }
        List<Double> ans = new ArrayList<>();
        for(List<Integer> list : arr){
            long sum = 0;
            for(int e : list){
                sum += e;
            }
            ans.add((double)sum/list.size());
        }
        return ans;
    }
}