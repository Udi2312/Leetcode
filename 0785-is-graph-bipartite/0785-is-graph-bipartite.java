class Solution {
        static boolean flag = true;
    public void bfs(int[][] graph, int arr[], int i){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        arr[i] = 0;
        // arr[i] = 0;
        while(q.size() > 0){
            int front = q.remove();
            int color = arr[front];
            for(int n: graph[front]){
                 if(arr[n]==arr[front]){
                    flag = false;
                    return;
                 }
                 if(arr[n] == -1){
                    arr[n] = 1-color;
                    q.add(n);
                 }
            }
        }
    }
    public boolean isBipartite(int[][] graph) {
        flag = true;
        int n = graph.length;
        // int m = graph[0].length;
        int arr[] = new int[n];
        Arrays.fill(arr, -1);
        for(int i = 0; i<n; i++){
            if(!flag) return false;
            if(arr[i]==-1) bfs(graph,arr,i);
        }
        return flag;
    }
}