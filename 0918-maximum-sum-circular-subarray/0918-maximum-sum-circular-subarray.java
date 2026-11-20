class Solution {
     public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int currsum = nums[0];
        for(int i = 1; i<nums.length; i++){
            currsum = Math.max(nums[i] , currsum + nums[i]);
            ans = Math.max(ans , currsum);
        }
        return ans;
    }
    public int minsum(int[] nums){
       int ans = nums[0];
        int currsum = nums[0];
        for(int i = 1; i<nums.length; i++){
            currsum = Math.min(nums[i] , currsum + nums[i]);
            ans = Math.min(ans , currsum);
        }
        return ans; 
    }
    public int maxSubarraySumCircular(int[] nums) {
        int tot = 0;
        for(int e : nums) tot += e;
        int maxsum = maxSubArray(nums);
        if(maxsum < 0) return maxsum;
        return Math.max(maxsum , tot - minsum(nums));
    }
}