class Solution {
    public int helper(int[] nums, int i, int j, int[] dp){
        if(i>j) return 0;
        if(dp[i] != -1) return dp[i];
        int take = nums[i] + helper(nums, i+2, j, dp);
        int skip = helper(nums, i+1, j, dp);
        return dp[i] = Math.max(take , skip);
    }
    public int rob(int[] nums) {
         int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        int case1 = helper(nums, 0, n - 2, dp1);
        int case2 = helper(nums, 1, n - 1, dp2);
        return Math.max(case1, case2);
    }
}