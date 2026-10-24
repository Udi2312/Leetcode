class Solution {
    int timer;
    List<List<Integer>> ans;
    public void dfs(int node , int parent, boolean[] vis , List<List<Integer>> adj, int tin[], int low[]){
        vis[node] = true;
        tin[node] = timer;
        low[node] = timer;
        timer++;
        for(int e : adj.get(node)){
            if(e == parent) continue;
            if(!vis[e]){
                dfs(e , node, vis, adj, tin, low);
                low[node] = Math.min(low[node] , low[e]);
                if(low[e] > tin[node]){
                    ans.add(new ArrayList<>(Arrays.asList(e , node)));
                }
            }
            else{
                 low[node] = Math.min(low[node] , low[e]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        timer = 1;
         ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());
        for(List<Integer> l : connections){
            int u = l.get(0);
            int v = l.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean vis[] = new boolean[n];
        int tin[] = new int[n];
        int low[] = new int[n];
        dfs(0 , -1, vis,adj, tin, low);
        return ans;
    }
}