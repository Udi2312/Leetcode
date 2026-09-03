class Solution {
    static int dp[][];
    public int lcs(StringBuilder a, int ai, StringBuilder b, int bi){
        if(ai < 0 || bi < 0) return 0;
        if(dp[ai][bi] != -1) return dp[ai][bi];
        if(a.charAt(ai) == b.charAt(bi)) return dp[ai][bi] = 1 + lcs(a, ai-1, b, bi-1);
        else{
            return dp[ai][bi] = Math.max(lcs(a, ai-1, b, bi), lcs(a, ai, b, bi-1));
        }
    }
    public int longestPalindromeSubseq(String s) {
         dp = new int[s.length()][s.length()];

        for(int[] arr: dp){
            Arrays.fill(arr,-1);
        }

        StringBuilder x = new StringBuilder(s);
        StringBuilder y = new StringBuilder(s).reverse();
        return lcs(x, s.length()-1, y, s.length()-1);
    }
}