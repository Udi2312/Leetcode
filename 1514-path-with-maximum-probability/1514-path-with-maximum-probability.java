class Solution {
    class Pair implements Comparable<Pair>{
        int node;
        double cost;
        Pair(int node , double cost){
            this.node = node;
            this.cost = cost;
        }
        public int compareTo(Pair p){
            if(this.cost == p.cost) return this.node - p.node;
            return Double.compare(this.cost,p.cost);
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++) adj.add(new ArrayList<Pair>());
        for(int i = 0; i<edges.length; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1] , succProb[i]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0] , succProb[i]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        double ans[] = new double[n];
        Arrays.fill(ans , Integer.MIN_VALUE);
        ans[start] = 1;
        pq.add(new Pair(start , 1));
        while(pq.size() > 0){
            Pair front = pq.remove();
            for(Pair p : adj.get(front.node)){
               double tc = front.cost * p.cost;
                if(tc > ans[p.node]){
                    ans[p.node] = tc;
                    pq.add(new Pair(p.node , tc));
                }
            }
        }
        if(ans[end] == Integer.MIN_VALUE) return 0.0;
        return ans[end];
    }
}