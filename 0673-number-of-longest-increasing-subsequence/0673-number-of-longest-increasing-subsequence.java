class Solution {
    public int findNumberOfLIS(int[] nums) {
         int dp[] = new int[nums.length];
         int count[] = new int[nums.length];
        Arrays.fill(dp , 1);
        Arrays.fill(count , 1);
        for(int i = 1; i<nums.length; i++){
            for(int j = i-1; j>=0; j--){
                if(nums[i] > nums[j]){
                if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }

                    // Found another LIS of same length
                    else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }
        }

        int maxLength = 0;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {

            if (dp[i] > maxLength) {
                maxLength = dp[i];
                ans = count[i];
            }

            else if (dp[i] == maxLength) {
                ans += count[i];
            }
        }

        return ans;
    }
}