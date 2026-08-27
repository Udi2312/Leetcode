class Solution {
    public int helper(int n , int[] dp){
        if(isPerfect(n)) return 1;

        if(dp[n] != -1) return dp[n];
        int min = n;
        for(int i = 1; i*i<=n/2; i++){
         int count = helper(i*i,dp) + helper(n-i*i,dp);
            min = Math.min(min, count);
        }
        return dp[n] = min;
    }
    public boolean isPerfect(int n){
        int sq = (int)(Math.sqrt(n));
        if(sq * sq == n) return true;
        else return false;
    }
    public int numSquares(int n) {
         int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);

        return helper(n, dp);
        }
    }