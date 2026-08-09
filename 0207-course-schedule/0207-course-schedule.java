class Solution {
    public boolean canFinish(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());
        int indegree[] = new int[n];
        boolean vis[] = new boolean[n];
        for(int i = 0; i<pre.length; i++){
            int a = pre[i][0];
            int b = pre[i][1];
            adj.get(b).add(a);
            indegree[a]++;
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
            for(int i = 0; i<indegree.length; i++){
                if(indegree[i] == 0){
                    q.add(i);
                    vis[i] = true;
                }
            }
            while(q.size() > 0){
                int front = q.remove();
                ans.add(front);
                for(int e: adj.get(front)){
                    indegree[e]--;
                    if(indegree[e]==0) {
                        q.add(e);
                        vis[e] = true;
                    }
                }
            }
            if(ans.size() == n) return true;
            return false;
    }
}