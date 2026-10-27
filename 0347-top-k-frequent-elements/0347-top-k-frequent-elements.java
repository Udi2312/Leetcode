class Solution {
    class Pair implements Comparable<Pair>{
        int e;
        int freq;
        Pair(int e , int freq){
            this.e = e;
            this.freq = freq;
        }
        public int compareTo(Pair p){
            return Integer.compare(this.freq , p.freq);
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer , Integer> mp = new HashMap<>();
        for(int e : nums){
            mp.put(e , mp.getOrDefault(e , 0) +1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int e : mp.keySet()){
            pq.add(new Pair(e , mp.get(e)));
            if(pq.size() > k) pq.remove();
        }
        int ans[] = new int[k];
        for(int i = 0; i<k; i++){
            ans[i] = pq.remove().e;
        }
        return ans;
    }
}