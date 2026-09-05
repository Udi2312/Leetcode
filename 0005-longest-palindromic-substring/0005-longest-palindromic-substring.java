class Solution {
    public String countSubstrings(String s) {
        int n = s.length();
       List<String> ans = new ArrayList<>();
        int[][] dp = new int[n][n];
        for(int k = 0; k<n; k++){
            int i = 0;
            int j = k;
            while(j<n){
                if(i==j){
                    dp[i][j] = 1;
                    ans.add(s.substring(i,j+1));
                }
                else if(j==i+1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 1;
                        ans.add(s.substring(i,j+1));
                    } 
                }
                else{
                    if(s.charAt(i) == s.charAt(j)){
                        if(dp[i+1][j-1] == 1){
                            dp[i][j] = 1;
                           ans.add(s.substring(i,j+1));
                        }
                    }
                }
                i++; j++;
            }

        }
        String l = "";
        for(String a : ans){
            if(a.length() > l.length()){
                l = a;
            }
        }
        return l;
    }
    public String longestPalindrome(String s) {
        return countSubstrings(s);
    }
}