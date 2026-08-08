class Solution {
    public void bfs(int start, List<List<Integer>> adj, boolean visited[], int end){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while(q.size() != 0){
            int front = q.remove();
            for(int e : adj.get(front)){
                if(!visited[e]){
                    q.add(e);
                    visited[e] = true;
                    if(e==end) return;
                }
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(start==end) return true;
        boolean visited[] = new boolean[n];

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i<n; i++){
            List<Integer> l = new ArrayList<>();
            adj.add(l);
        }

        for(int i = 0; i<edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        bfs(start,adj,visited, end);
        return visited[end];
    }
}