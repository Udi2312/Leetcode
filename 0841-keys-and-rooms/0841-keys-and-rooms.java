class Solution {
    public void bfs(int i , List<List<Integer>> rooms, boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(q.size() > 0){
            int front = q.remove();
            for(int e : rooms.get(front)){
                if(!vis[e]){
                   q.add(e);
                   vis[e] = true;
                }
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        vis[0] = true;
        bfs(0,rooms,vis);
        for(boolean b : vis){
            if(!b) return false;
        }
        return true;
    }
}