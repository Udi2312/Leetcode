class Solution {

    int[][] dp;

    public boolean helper(String s, String p, int i, int j) {

        // Both strings completely matched
        if (i == s.length() && j == p.length()) {
            return true;
        }

        // Pattern finished but string isn't
        if (j == p.length()) {
            return false;
        }

        // String finished
        // Remaining pattern must consist entirely of '*'
        if (i == s.length()) {
            for (int k = j; k < p.length(); k++) {
                if (p.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        boolean ans;

        if (p.charAt(j) == '*') {

            // '*' matches zero characters
            boolean skip = helper(s, p, i, j + 1);

            // '*' matches one or more characters
            boolean take = helper(s, p, i + 1, j);

            ans = skip || take;

        } else if (p.charAt(j) == '?' ||
                   s.charAt(i) == p.charAt(j)) {

            ans = helper(s, p, i + 1, j + 1);

        } else {
            ans = false;
        }

        dp[i][j] = ans ? 1 : 0;
        return ans;
    }

    public boolean isMatch(String s, String p) {

        dp = new int[s.length()][p.length()];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(s, p, 0, 0);
    }
}