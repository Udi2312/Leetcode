class Solution {
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int e : arr) pq.add(e);
        HashMap<Integer, Integer> mp = new HashMap<>();
        int count = 1;
        while(pq.size() > 0){
            int e = pq.remove();
            if(!mp.containsKey(e)){
                mp.put(e,count);
                count++;
            }
        }
        int ans[] = new int[arr.length];
        for(int i = 0; i<arr.length; i++){
            ans[i] = mp.get(arr[i]);
        }
        return ans;
    }
}