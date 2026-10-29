/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    class Pair{
        Node n;
        int l;
        Pair(Node n , int l){
            this.n = n;
            this.l = l;
        }
    }
    public Node connect(Node root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root , 0));
        while(q.size() > 0){
            Pair front = q.remove();
            if(front.n == null) continue;
            if(q.size() > 0 && q.peek().n != null && q.peek().l == front.l){
                front.n.next = q.peek().n; 
            }
           if(front.n.left != null) q.add(new Pair(front.n.left, front.l+1));
           if(front.n.right != null) q.add(new Pair(front.n.right, front.l+1));
        }
        return root;
    }
}