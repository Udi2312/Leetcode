class Solution {
    public boolean check(String s, int i, int j){
        int l = i;
        int m = j;
        while(l<m){
            if(s.charAt(l) == s.charAt(m)){
                l++;
                m--;
            }
            else return false;
        }
        return true;
    }
    public int helper(String s, int i, int j,int dp[][]){
        if(i>=j) return 0;
        if(check(s, i, j)) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k = i; k<j; k++){
            if (check(s, i, k)) {
                int cuts = 1 + helper(s, k + 1, j,dp);
                min = Math.min(min, cuts);
            }
        }
        return dp[i][j]= min;
    }
    public int minCut(String s) {
        if(check(s,0,s.length()-1)) return 0;
        int dp[][] = new int[s.length()][s.length()];
        for(int arr[]: dp) Arrays.fill(arr,-1);
        return helper(s,0,s.length()-1,dp);
    }
}