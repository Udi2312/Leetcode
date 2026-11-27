class Solution {
     public int helper(int[] nums , int[] dp , int i, int j){
        if(i > j) return 0;
        if(dp[i] != -1) return dp[i];
        int pick = nums[i] + helper(nums,dp,i+2,j);
        int skip = helper(nums,dp,i+1,j);
        return dp[i] = Math.max(pick,skip);
    }
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int dp1[] = new int[nums.length+1];
        int dp2[] = new int[nums.length+1];
        Arrays.fill(dp1 , -1);
        Arrays.fill(dp2 , -1);
        return Math.max(helper(nums , dp1 , 0,nums.length-2) , helper(nums , dp2 , 1,nums.length-1));
    }
}