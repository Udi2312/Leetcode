class Solution {
    class Pair{
        int node;
        int cost;
        Pair(int node , int cost){
            this.node = node;
            this.cost = cost;
        }
    }

    class Trip{
        int node;
        int cost;
        int st;
        Trip(int node , int cost, int st){
            this.node = node;
            this.cost = cost;
            this.st = st;
        }
    }
    public int findCheapestPrice(int n, int[][] arr, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());
        for(int a[] : arr){
            adj.get(a[0]).add(new Pair(a[1] , a[2]));
        }
        Queue<Trip> q = new LinkedList<>();
        q.add(new Trip(src , 0 , 0));
        int ans[] = new int[n];
        Arrays.fill(ans , Integer.MAX_VALUE);
        ans[src] = 0;
        while(q.size() > 0){
            Trip front = q.remove();
            int node = front.node;
            int cost = front.cost;
            int st = front.st;
            if(st == k+1) continue;
            for(Pair p : adj.get(node)){
                if(ans[p.node] > cost + p.cost){
                    ans[p.node] = cost + p.cost;
                    q.add(new Trip(p.node , cost + p.cost, st+1));
                }
            }
        }
        if(ans[dst] == Integer.MAX_VALUE) return -1;
        return ans[dst];
    }
}