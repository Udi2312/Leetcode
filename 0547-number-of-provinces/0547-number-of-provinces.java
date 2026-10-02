class Solution {
    public void bfs(int i , int[][] arr, boolean[] vis){
        vis[i] = true;
        int n = arr.length;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(q.size() > 0){
            int front = q.remove();
            for(int j = 0; j<n; j++){
                if(arr[front][j] == 1 && !vis[j]){
                    q.add(j);
                    vis[j] = true;
                }
            }
        }
    }
    public int findCircleNum(int[][] arr) {
        int n = arr.length;
        int count = 0;
        boolean isVisited[] = new boolean[n];
        for(int i = 0; i<n; i++){
            if(!isVisited[i]){
                bfs(i,arr,isVisited);
                count++;
            }
        }
        return count;
    }
}