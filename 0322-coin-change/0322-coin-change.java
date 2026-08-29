class Solution {
    public long helper(int[] coins, int amount, int i, long[][] dp){
        if(i==coins.length){
            if(amount == 0) return 0;
            else return Integer.MAX_VALUE;
        }
        if(dp[i][amount] != -1) return dp[i][amount];
       long skip = helper(coins , amount, i+1, dp);
       if(amount - coins[i] < 0) return skip;
       long pick = 1 + helper(coins , amount-coins[i], i, dp);
       return dp[i][amount] = Math.min(skip , pick);
    }
    public int coinChange(int[] coins, int amount) {
        long dp[][] = new long[coins.length][amount+1];
        for(long i[] : dp){
            Arrays.fill(i , -1);
        }
        int ans = (int) helper(coins , amount , 0, dp);
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
}