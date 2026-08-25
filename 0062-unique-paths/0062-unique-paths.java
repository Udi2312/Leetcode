class Solution {

    public int helper(int m, int n, int[][] dp) {

        if (m == 1 || n == 1) {
            return 1;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        return dp[m][n] = helper(m - 1, n, dp)
                        + helper(m, n - 1, dp);
    }

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(m, n, dp);
    }
}