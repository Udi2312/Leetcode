class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<graph.length; i++) adj.add(new ArrayList<>());
        int inde[] = new int[graph.length];
        for(int i = 0; i<graph.length; i++){
            for(int e: graph[i]){
             adj.get(e).add(i);
             inde[i]++;
            }
        }
        for(int i = 0; i<inde.length; i++){
            if(inde[i]==0) q.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        while(q.size() > 0){
            int front = q.remove();
            ans.add(front);
            for(int e : adj.get(front)){
                inde[e]--;
                if(inde[e] == 0) q.add(e);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}