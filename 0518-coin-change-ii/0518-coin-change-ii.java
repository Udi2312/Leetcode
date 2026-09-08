class Solution {
    public int helper(int[] coins, int amount, int i, int[][] dp){
        if(i==coins.length){
            if(amount == 0) return 1;
            else return 0;
        }
        if(dp[i][amount] != -1) return dp[i][amount];
       int skip = helper(coins , amount, i+1, dp);
       if(amount - coins[i] < 0) return skip;
       int pick = helper(coins , amount-coins[i], i, dp);
       return dp[i][amount] = skip + pick;
    }
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length][amount+1];
        for(int i[] : dp){
            Arrays.fill(i , -1);
        }
        int ans = helper(coins , amount , 0, dp);
        // if(ans == Integer.MAX_VALUE) return 0;
        return ans;
    }
}