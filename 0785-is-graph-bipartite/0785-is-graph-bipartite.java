class Solution {
    static boolean flag;
    public void bfs(int i , int[][] adj , int[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i] = 0;
        while(q.size() > 0){
            int front = q.remove();
            int col = vis[front];
            for(int e : adj[front]){
                if(vis[e] == col){
                    flag = false;
                    return;
                }
                if(vis[e] == -1){
                    vis[e] = 1-col;
                    q.add(e);
                }
            }
        }
    }
    public boolean isBipartite(int[][] graph) {
        flag = true;
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis , -1);
        for(int i = 0; i<n; i++){
            if(!flag) return false;
            if(vis[i] == -1) bfs(i , graph, vis);
        }
        return flag;
    }
}