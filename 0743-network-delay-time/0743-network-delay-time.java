class Solution {
    class Pair implements Comparable<Pair>{
        int n;
        int t;
        Pair(int n, int t){
            this.n = n;
            this.t = t;
        }
        public int compareTo(Pair p){
            if(this.t == p.t) return this.n-p.n;
            return this.t - p.t;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<=n; i++) adj.add(new ArrayList<Pair>());
        for(int arr[] : times){
            adj.get(arr[0]).add(new Pair(arr[1] , arr[2]));
        }
        int ans[] = new int[n+1];
        Arrays.fill(ans , Integer.MAX_VALUE);
        ans[k] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(k , 0));
        while(pq.size() > 0){
            Pair top = pq.remove();
            int no = top.n;
            int t = top.t;
            if(t > ans[no]) continue;
            for(Pair p : adj.get(no)){
                int totaldis = t + p.t;
                if(ans[p.n] > totaldis){
                    ans[p.n] = totaldis;
                    pq.add(new Pair(p.n, totaldis));
                }
            }
        }
        int max = 0;
        for (int i = 1; i<= n; i++) {
            if (ans[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, ans[i]);
        }
        return max;
    }
}