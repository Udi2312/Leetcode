class Solution {
    public void bfs(List<List<Integer>> adj, int[][] arr, boolean vis[], int i){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i] = true;
        while(q.size() > 0){
            int front = q.remove();
            for(int con : adj.get(front)){
                if(!vis[con]){
                vis[con] = true;
                q.add(con);
                }
            }
        }
    }
    public int makeConnected(int n, int[][] arr) {
        if(n > arr.length+1) return -1;
        boolean vis[] = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());
        for(int a[] : arr){
            adj.get(a[0]).add(a[1]);
            adj.get(a[1]).add(a[0]);
        }
        int ans = 0;
        for(int i = 0; i<n; i++){
            if(!vis[i]){
                bfs(adj , arr , vis , i);
                ans++;
            }
        }
        return ans-1;
    }
}