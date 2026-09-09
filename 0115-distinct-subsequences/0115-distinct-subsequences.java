class Solution {
    // int count;
    public int generate(String s, int i, String t, int j,int dp[][]){
        if(j==t.length()){
            return 1;
        }
        if(dp[i][j] != -1) return dp[i][j];
        if(i==s.length()) return 0;
        int skip = generate(s,i+1,t,j, dp);
        int take = 0;
        if(s.charAt(i) == t.charAt(j)) take = generate(s,i+1,t,j+1, dp);
       return dp[i][j] = skip + take;
    }
    public int numDistinct(String s, String t) {
        // count = 0;
        int dp[][] = new int[s.length()+1][s.length()+1];
        for(int arr[] : dp) Arrays.fill(arr,-1);
        return generate(s,0,t,0,dp);
        // return count;
    }
}