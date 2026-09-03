class Solution {
    static int dp[][];
    public int minSteps(StringBuilder a , StringBuilder b, int i, int j){
        if(i==-1) return j+1;
        if(j==-1) return i+1;
        if(dp[i][j] != -1) return dp[i][j];
        if(a.charAt(i) == b.charAt(j)){
            return dp[i][j] = minSteps(a,b,i-1,j-1);
        }
        else{
            int del = minSteps(a,b,i-1,j);
            int ins = minSteps(a,b,i,j-1);
            int rep = minSteps(a,b,i-1,j-1);
            return dp[i][j] = 1 + Math.min(del, Math.min(ins,rep));
        }
    }
    public int minDistance(String word1, String word2) {
        StringBuilder a = new StringBuilder(word1);
        StringBuilder b = new StringBuilder(word2);
        dp = new int[a.length()][b.length()];

        for(int[] arr: dp){
            Arrays.fill(arr,-1);
        }
        int m = a.length();
        int n = b.length();
        return minSteps(a,b,m-1,n-1);
    }
}