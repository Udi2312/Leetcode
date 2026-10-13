class Solution {
    class Pair implements Comparable<Pair>{
        int node;
        long cost;
        Pair(int node , long cost){
            this.node = node;
            this.cost = cost;
        }
        public int compareTo(Pair p){
            if(this.cost == p.cost) return this.node - p.node;
            return Long.compare(this.cost, p.cost);
        }
    }
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());
        long ans[] = new long[n];
        long ways[] = new long[n];
        ways[0] = 1;
        Arrays.fill(ans , Long.MAX_VALUE);
        ans[0] = 0;
        for(int arr[] : roads){
            adj.get(arr[0]).add(new Pair(arr[1] , arr[2]));
            adj.get(arr[1]).add(new Pair(arr[0] , arr[2]));
        }
        PriorityQueue<Pair> q = new PriorityQueue<Pair>();
        q.add(new Pair(0 , 0));
        while(q.size() > 0){
            Pair front = q.remove();
            for(Pair p : adj.get(front.node)){
                if(ans[p.node] > front.cost + p.cost){
                    ans[p.node] = (front.cost + p.cost);
                    ways[p.node] = ways[front.node];
                    q.add(new Pair(p.node , front.cost + p.cost));
                }
                else if(ans[p.node] == front.cost + p.cost){
                    ways[p.node] = (ways[p.node] + ways[front.node]) % 1000000007;
                }
            }
        }
        return (int)(ways[n-1]);
    }
}