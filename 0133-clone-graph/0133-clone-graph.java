/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node , Node> mp = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node clone = new Node();
        clone.val = node.val;
        mp.put(node , clone);
        q.add(node);
        while(q.size() > 0){
        Node front = q.remove();
        List<Node> adj = front.neighbors;
        for(Node n : adj){
            if(!mp.containsKey(n)){
                Node c = new Node(n.val);
                mp.put(n,c);
                q.add(n);
            }
            mp.get(front).neighbors.add(mp.get(n));
        }
        }
        return clone;
    }
}
