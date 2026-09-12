class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
 int dp[] = new int[nums.length];
         int[] parent = new int[nums.length];
        Arrays.fill(dp , 1);
        Arrays.fill(parent , -1);
        Arrays.sort(nums);
                int maxIndex = 0;
        for(int i = 1; i<nums.length; i++){
            for(int j = i-1; j>=0; j--){
               if (nums[i] % nums[j] == 0 &&
                    dp[j] + 1 > dp[i]) {

                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }

            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (maxIndex != -1) {
            ans.add(nums[maxIndex]);
            maxIndex = parent[maxIndex];
        }

        // Collections.reverse(ans);

        return ans;
    }
}