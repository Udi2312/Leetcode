class Solution {
    public boolean canFinish(int n, int[][] pre) {
        List<List<Integer>> arr = new ArrayList<>();
        for(int i = 0; i<n; i++) arr.add(new ArrayList<>());
        int indegree[] = new int[n];
        for(int a[] : pre){
            arr.get(a[1]).add(a[0]);
            indegree[a[0]]++;
        }
        // boolean[] vis = new boolean[n];
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            if(indegree[i] == 0){
                // vis[i] = true;
                q.add(i);
            }
        }
        while(q.size() > 0){
            int front = q.remove();
            ans.add(front);
            // vis[front] = true;
            for(int a : arr.get(front)){
                indegree[a]--;
                if(indegree[a] == 0){
                    q.add(a);
                }
            }
        }
        return ans.size() == n;
    }
}