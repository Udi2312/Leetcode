class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp , 1);
        for(int i = 1; i<nums.length; i++){
            int min = Integer.MIN_VALUE;
            for(int j = i-1; j>=0; j--){
                if(nums[i] > nums[j]){
                    if(dp[j] > min){
                        dp[i] = 1 + dp[j];
                        min = dp[j];
                    }
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int var: dp){
            if(var>ans) ans = var;
        }
        return ans;
    }
}