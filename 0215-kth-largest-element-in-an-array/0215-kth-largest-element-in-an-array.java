class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int e : nums) pq.add(e);
        int ans = 0;
        while(k > 0){
            ans = pq.remove();
            k--;
        }
        return ans;
    }
}