class Solution {
    public int minCost(int cost[] , int i, int[] dp){
        if(i <= 1) return cost[i];
        if(dp[i] != -1) return dp[i];
      return dp[i] = cost[i] + Math.min(minCost(cost , i-1, dp), minCost(cost , i-2, dp));
    }
    public int minCostClimbingStairs(int[] cost) {
       int i = cost.length;
       int dp [] = new int[i];
       Arrays.fill(dp, -1);
        return Math.min(minCost(cost , i-2, dp) , minCost(cost , i-1, dp));
    }
}