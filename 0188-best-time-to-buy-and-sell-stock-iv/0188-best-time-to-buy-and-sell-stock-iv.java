class Solution {
    public int helper(int k , int arr[] , int buy , int idx, int dp[][][]){
        if(idx==arr.length) return 0;
        if(k==0) return 0;
        if(dp[k][buy][idx] != -1) return dp[k][buy][idx];
        int profit = 0;
        if(buy == 1){
            profit = Math.max(-arr[idx] + helper(k,arr,0,idx+1, dp) , helper(k,arr,1,idx+1, dp));
        }
        else{
            profit = Math.max(arr[idx] + helper(k-1,arr,1,idx+1, dp) , helper(k,arr,0,idx+1, dp));
        }
        return dp[k][buy][idx] = profit;
    }
    public int maxProfit(int k, int[] prices) {
        int dp[][][] = new int[k+1][3][prices.length+1];
        for(int arr[][] : dp){
            for(int ar[] : arr) Arrays.fill(ar , -1);
        }
        return helper(k,prices,1,0, dp);
    }
}