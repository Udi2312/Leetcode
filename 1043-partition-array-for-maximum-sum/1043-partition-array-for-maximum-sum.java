class Solution {
    public int maxi(int[] arr, int i, int j){
        int ans = -1;
        for(int k = i; k<=j; k++){
            if(arr[k] > ans) ans = arr[k];
        }
        return ans;
    }
    public int helper(int[] arr, int k1, int i, int j,int dp[][]){
        if(i>j) return 0;
        // if(j-i>=k1) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int max = Integer.MIN_VALUE;
        for(int k = i; k<=Math.min(j, i + k1 - 1); k++){
            int sum = (k-i+1)*maxi(arr,i,k) + helper(arr,k1,k+1,j,dp);
            max = Math.max(max,sum);
        }
        return dp[i][j]= max;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[][] = new int[n][n];
        for(int arr1[] : dp) Arrays.fill(arr1,-1);
        return helper(arr,k,0,n-1,dp);
    }
}