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
    public int longestCommonSubsequence(String a, String b) {
        dp = new int[a.length()][b.length()];

        for(int[] arr: dp){
            Arrays.fill(arr,-1);
        }

        StringBuilder x = new StringBuilder(a);
        StringBuilder y = new StringBuilder(b);
       return lcs(x, a.length()-1, y, b.length()-1);
    }

    public int minDistance(String a, String b) {
        int cs = longestCommonSubsequence(a,b);
        if(a.length() == b.length()){
            return (a.length() - cs) * 2;
        }
        else{
          int x = Math.min(a.length() , b.length()) - cs;
          int y = Math.max(a.length() , b.length()) - cs;
          return x + y;
        }
    }
}