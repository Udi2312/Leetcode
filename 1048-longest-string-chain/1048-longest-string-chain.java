class Solution {
    public boolean compare(String s , String k){
        if(Math.abs(s.length() - k.length()) != 1) return false;
        int i = 0;
        int j = 0;
        while (i < s.length() && j < k.length()) {
        if (s.charAt(i) == k.charAt(j)) {
            j++;
        }
        i++;
    }
    return j == k.length();
    }
    public int longestStrChain(String[] nums) {
        int dp[] = new int[nums.length];
        Arrays.sort(nums, Comparator.comparingInt(String::length));
        Arrays.fill(dp , 1);
        int max = 1;
        for(int i = 1; i<nums.length; i++){
            for(int j = i-1; j>=0; j--){
                if(compare(nums[i],nums[j]) && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }
                if(dp[i] > max) max = dp[i];
        }
        return max;
    }
}