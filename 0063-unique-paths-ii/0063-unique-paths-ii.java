class Solution {
    
    public int helper(int[][] arr , int m, int n, int[][] dp) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if(arr[m][n] == 1) return 0;
        if (m == 0 && n == 0) {
            return 1;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        return dp[m][n] = helper(arr,m - 1, n, dp)
                        + helper(arr,m, n - 1, dp);
    }

    
    public int uniquePathsWithObstacles(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
         int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(arr,m-1, n-1, dp);
    }
    
}