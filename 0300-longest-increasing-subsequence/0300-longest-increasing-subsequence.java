class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i = 1; i<nums.length; i++){
            for(int j = i-1; j>=0; j--){
            if(nums[i] > nums[j]){
               if(dp[i] <= dp[j]) dp[i] = 1+dp[j];
            //    else dp[i] = Math.max(dp[i],dp[j]);
            }
        }
    }
        int ans = -1;
        for(int e : dp) ans = Math.max(ans , e);
        return ans;
    }
}