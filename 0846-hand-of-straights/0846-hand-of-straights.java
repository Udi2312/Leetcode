class Solution {
    class Pair implements Comparable<Pair>{
        int num;
        int freq;
        Pair(int num, int freq){
            this.num = num;
            this.freq = freq;
        }
        public int compareTo(Pair p){
            return Integer.compare(this.num, p.num);
        }
    }
    public boolean isNStraightHand(int[] arr, int n) {
        if(arr.length % n != 0) return false;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int e : arr){
            mp.put(e, mp.getOrDefault(e , 0) + 1);
        }
        for(int e : mp.keySet()){
            pq.add(new Pair(e , mp.get(e)));
        }
        while(pq.size() > 0){
            List<Pair> temp = new ArrayList<>();
            for(int i = 0; i<n && pq.size() > 0; i++){
            Pair p = pq.remove();
            temp.add(p);
            }
            if(temp.size() < n) return false;
            for(int j = 1; j<n; j++){
                if(temp.get(j).num != temp.get(j-1).num + 1){
                    return false;
                }
            }
            for(Pair p : temp){
                p.freq = p.freq-1;
                if(p.freq > 0) pq.add(p);
            }
        }
        return true;
    }
}