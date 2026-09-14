class Solution {
    public int maxSubArray(int[] nums) {
        int currans = nums[0];
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++) {
            currans = Math.max(nums[i], currans + nums[i]);
            ans = Math.max(ans, currans);
        }
        return ans;
    }
}