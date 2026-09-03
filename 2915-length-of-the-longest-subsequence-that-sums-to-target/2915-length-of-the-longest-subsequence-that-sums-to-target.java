class Solution {
    // List<List<Integer>> ans = new ArrayList<>();
    public int helper(List<Integer> nums, int target, int i, int dp[][]){
        if(target == 0){
            return 0;
        }
        if (i == nums.size() || target < 0) {
            return -1000000;
        }
        if(dp[target][i] != -1) return dp[target][i];
        //  Take
        // curr.add(nums.get(i));
       int take = 1+ helper(nums,target-nums.get(i), i+1,dp);
        // curr.remove(curr.size()-1);

        // leave
        int skip = helper(nums, target, i+1,dp);
        return dp[target][i] =  Math.max(take , skip);

    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int dp[][] = new int[target+1][nums.size()];
        for(int[] arr: dp){
            Arrays.fill(arr,-1);
        }

        int ans = helper(nums , target , 0, dp);
        // int len = -1;
        // for(List<Integer> i : ans){
        //     if(i.size() > len){
        //         len = i.size();
        //     }
        // }
        if(ans < 0) return -1;
        else return ans;
        // return len;
    }
}