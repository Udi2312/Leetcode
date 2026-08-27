class Solution {
    public boolean subset(int i, int[] arr, int target, int[][] dp){
        if(i==arr.length){
            if(target==0) return true;
            return false;
        }
        if(dp[i][target] != -1) return dp[i][target]==1;
        boolean ans = false;
        boolean skip = subset(i+1, arr, target, dp);
        if(target-arr[i] < 0) ans = skip;

        else{
        boolean take = subset(i+1, arr, target-arr[i], dp);
        ans = take || skip;
        }

        dp[i][target] = ans ? 1 : 0;
        return ans;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int e: nums) sum += e;
        if(sum%2 != 0) return false;
        int dp[][] = new int[nums.length][sum/2 +1];
        for(int arr[] : dp){
            Arrays.fill(arr,-1);
        }
        return subset(0,nums,sum/2,dp);
    }
}