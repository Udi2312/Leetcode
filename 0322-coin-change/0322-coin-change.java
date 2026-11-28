class Solution {
    public long helper(int[] coins, long dp[][], int amount,int i){
        if(i == coins.length){
            if(amount == 0) return 0;
            else return Integer.MAX_VALUE;
        }
        if(dp[i][amount] != -1) return dp[i][amount];
        long skip = helper(coins , dp, amount,i+1);
        if(amount-coins[i] < 0) return skip;
        long pick = helper(coins , dp, amount-coins[i],i)+1;
        return dp[i][amount] = Math.min(pick,skip);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        long dp[][] = new long[n+1][amount+1];
        for(long arr[] : dp )Arrays.fill(arr,-1);
        int ans= (int)helper(coins,dp,amount,0);
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
}