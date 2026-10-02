class Solution {
    public void bfs(int s , int d , List<List<Integer>> adj, boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while(q.size() > 0){
            int front = q.remove();
            for(int e : adj.get(front)){
                if(!vis[e]){
                    vis[e] = true;
                    q.add(e);
                }
            }
        }
    } 
    public boolean validPath(int n, int[][] edges, int s, int d) {
        if(s==d) return true;
        boolean[] vis = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i<edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        bfs(s , d , adj, vis);
        return vis[d];
    }
}