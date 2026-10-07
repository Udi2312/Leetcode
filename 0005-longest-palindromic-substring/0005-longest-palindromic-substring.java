class Solution {
    public boolean isSubstring(String s , int i , int j, int[][] dp){
        if(i >= j) return true;
        if(dp[i][j] != -1) return dp[i][j] == 1;
        if(s.charAt(i) == s.charAt(j)){
        boolean flag = isSubstring(s , i+1, j-1, dp);
        if(flag){
            dp[i][j] = 1;
            return true;
        }
        else{
            dp[i][j] = 0;
            return false;
        }
        }
        dp[i][j]= 0;
        return false;
    }
    public String longestPalindrome(String s) {
        if(s.length() == 1) return s;
        String ans = "";
        int dp[][] = new int[s.length()][s.length()];
        for(int arr[] : dp) Arrays.fill(arr , -1);
        for(int i = 0; i<s.length(); i++){
            for(int j = i; j<s.length(); j++){
                if(isSubstring(s , i, j, dp)){
                    if(ans.length() < j-i+1) ans = s.substring(i ,j+1);
                }
            }
        }
        return ans;
    }
}
