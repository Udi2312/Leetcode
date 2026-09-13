class Solution {
    public int helper(int[] nums2 , int i, int j, int dp[][]){
        if(i>j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int max = Integer.MIN_VALUE;
        for(int k = i; k<=j; k++){
            int cost = (nums2[i - 1] * nums2[k] * nums2[j + 1]) + helper(nums2,i,k-1, dp) + helper(nums2 , k+1,j,dp);
            max = Math.max(cost,max);
        }
        return dp[i][j] = max;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n+2][n+2];
        for(int arr[] : dp) Arrays.fill(arr,-1);
        int[] nums2 = new int[n + 2];
        int k = 1;
        nums2[0] = 1;
        for(int i = 0; i<n; i++){
            nums2[k++] = nums[i];
        }
        nums2[k] = 1;
        // System.out.println(nums2[n+1]);
        return helper(nums2,1,n, dp);
    }
}