class Solution {
    public int sum;
    public int helper(int[] nums, int target,int res, int i, int dp[][]){
        if(i == nums.length){
            if(target == res) return 1;
            else return 0;
        }
        if(dp[res + sum][i] != -1) return dp[res + sum][i];
        int sub = helper(nums , target,res-nums[i], i+1, dp);
        int add = helper(nums , target,res+nums[i], i+1, dp);
        return dp[res+sum][i] =  add + sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        sum = 0;
        for(int s : nums) sum += s;
        int dp[][] = new int[2 * sum+1][nums.length];
        for(int i[] : dp) Arrays.fill(i , -1);

        return helper(nums, target,0, 0, dp);
    }
}