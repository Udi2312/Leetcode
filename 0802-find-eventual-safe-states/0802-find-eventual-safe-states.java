class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int in[] = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<n; i++){
            for(int e: graph[i]){
                adj.get(e).add(i);
                in[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            if(in[i] == 0) q.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        while(q.size() > 0){
            int front = q.remove();
            ans.add(front);
            for(int i : adj.get(front)){
                in[i]--;
                if(in[i] == 0) q.add(i);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}