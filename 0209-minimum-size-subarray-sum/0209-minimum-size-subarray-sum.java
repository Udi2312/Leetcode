class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int currsum = 0;
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            currsum += nums[j];
            while (currsum >= target) {
                ans = Math.min(ans, j - i + 1);
                currsum -= nums[i];
                i++;
            }
        }
        if(ans == Integer.MAX_VALUE) return 0;
        return ans;
    }
}