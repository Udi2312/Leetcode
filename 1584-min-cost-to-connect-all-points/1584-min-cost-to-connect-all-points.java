class Solution {
     class Trip implements Comparable<Trip>{
        int node;
        int parent;
        int dist;
        Trip(int node, int parent, int dist){
            this.node = node;
            this.parent = parent;
            this.dist = dist;
        }
        public int compareTo(Trip t){
            if(this.dist == t.dist) return this.node-t.node;
            return this.dist -  t.dist;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Trip> pq = new PriorityQueue<>();
        pq.add(new Trip(0,-1,0));
        int sum = 0;
        boolean vis[] = new boolean[points.length];
        while(pq.size() > 0){
            Trip top = pq.remove();
            int node = top.node;
            int parent = top.parent;
            int dist = top.dist;
            if(vis[node]==true) continue;
            sum += dist;
            vis[node] = true;
            for(int i = 0; i<points.length; i++){
                if(i==node || i==parent) continue;
                if(vis[i]==true) continue;
                int x1 = points[node][0] , y1 = points[node][1];
                int x2 = points[i][0] , y2 = points[i][1];
                int mdis = Math.abs(x2-x1) + Math.abs(y2-y1);
                pq.add(new Trip(i,node,mdis));
            }
        }
        return sum;
    }
}