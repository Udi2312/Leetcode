class Solution {
    public int helper(String s , int i, int dp[]){
        if(i == s.length()){
            return 1;
        }
        if(dp[i] != -1) return dp[i];
        char ch = s.charAt(i);
        if(ch == '0') return 0;
        int f = helper(s , i+1, dp);
        int s1 = 0;
        if(i+1 < s.length()){
        if(ch == '1' || (ch == '2' && s.charAt(i+1) <= '6')) s1  = helper(s , i+2, dp);
        }
        return dp[i] = f + s1;
    }
    public int numDecodings(String s) {
        int dp[] = new int[s.length()+1];
        Arrays.fill(dp , -1);
        return helper(s , 0, dp);
    }
}
