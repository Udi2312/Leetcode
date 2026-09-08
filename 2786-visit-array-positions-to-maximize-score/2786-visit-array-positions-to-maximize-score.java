class Solution {
    long dp[][];
    public long helper(int nums[], int x, int i, int prev){
        if(i==nums.length){
            return 0;
        }
        if(dp[i][prev] != -1) return dp[i][prev];
        // skip
        long skip = helper(nums,x,i+1,prev);
        // pick
        long pick = nums[i];
        if(nums[i]%2 != prev) pick -= x;
        pick += helper(nums,x,i+1,nums[i]%2);

        return dp[i][prev] = Math.max(pick , skip);
    }
    public long maxScore(int[] nums, int x) {
         dp = new long[nums.length][2];
         for(long i[] : dp) Arrays.fill(i,-1);
        return nums[0] + helper(nums,x,1,nums[0]%2);
    }
}