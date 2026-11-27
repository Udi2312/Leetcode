class Solution {
    public int helper(int[] nums , int[] dp , int i){
        if(i >= nums.length) return 0;
        if(dp[i] != -1) return dp[i];
        int pick = nums[i] + helper(nums,dp,i+2);
        int skip = helper(nums,dp,i+1);
        return dp[i] = Math.max(pick,skip);
    }
    public int rob(int[] nums) {
        int dp[] = new int[nums.length+1];
        Arrays.fill(dp , -1);
        return helper(nums , dp , 0);
    }
}