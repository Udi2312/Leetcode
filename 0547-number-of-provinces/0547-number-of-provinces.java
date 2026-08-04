class Solution {
    public void bfs(int idx , int[][] adj,boolean isVisited[]){
        isVisited[idx] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        while(q.size() > 0){
            int front = q.remove();
            for(int i = 0; i<adj.length; i++){
                if(adj[front][i] == 1 && !isVisited[i]){
                    q.add(i);
                    isVisited[i] = true;
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean isVisited[] = new boolean[n];
        for(int i = 0; i<n; i++){
            if(!isVisited[i]){
                bfs(i,isConnected,isVisited);
                count++;
            }
        }
        return count;
    }
}