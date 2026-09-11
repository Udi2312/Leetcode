class Solution {
    public int helper(int arr[] , int buy , int idx, int dp[][], int fee){
        if(idx>=arr.length) return 0;
        if(dp[buy][idx] != -1) return dp[buy][idx];
        int profit = 0;
        if(buy == 1){
            profit = Math.max(-arr[idx] + helper(arr,0,idx+1, dp, fee) , helper(arr,1,idx+1, dp, fee));
        }
        else{
            profit = Math.max(arr[idx] + helper(arr,1,idx+1, dp, fee) - fee , helper(arr,0,idx+1, dp, fee));
        }
        return dp[buy][idx] = profit;
    }
    public int maxProfit(int[] prices, int fee) {
        int dp[][] = new int[3][prices.length+1];
        for(int arr[] : dp){
           Arrays.fill(arr , -1);
        }
        return helper(prices,1,0, dp, fee);
    }
}