class Solution {
    public boolean canFinish(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        int indegree[] = new int[n];
        boolean vis[] = new boolean[n];
        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());
        for(int e[] : pre){
         adj.get(e[1]).add(e[0]);
         indegree[e[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(indegree[i] == 0) {
                q.add(i);
                vis[i] = true;
            }
        }
        while(q.size() > 0){
            int front = q.remove();
            ans.add(front);
            for(int e : adj.get(front)){
                indegree[e]--;
                if(indegree[e] == 0){
                    q.add(e);
                    vis[e] = true;
                }
            }
        }
        return ans.size() == n;
    }
}