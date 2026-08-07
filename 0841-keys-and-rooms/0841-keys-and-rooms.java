class Solution {
    public void bfs(int start , List<List<Integer>> rooms, boolean isVisited[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(q.size() > 0){
            int front = q.remove();
            for(int e : rooms.get(front)){
                if(!isVisited[e]){
                    isVisited[e] = true;
                    q.add(e);
                }
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean isVisited[] = new boolean[n];
        isVisited[0] = true;
        bfs(0,rooms,isVisited);
        for(boolean b : isVisited){
            if(!b) return false;
        }
        return true;
    }
}