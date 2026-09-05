class Solution {
    public int helper(List<List<Integer>> tri, int i , int j, int dp[][]){
        if(i==tri.size()-1) return tri.get(i).get(j);
        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        int down = helper(tri, i+1,j, dp);
        int diag = helper(tri, i+1,j+1, dp);
        return dp[i][j] = tri.get(i).get(j) + Math.min(down , diag);
    }
    public int minimumTotal(List<List<Integer>> tri) {
        int dp[][] = new int[tri.size()][tri.size()];
        for(int i[] : dp) Arrays.fill(i , Integer.MAX_VALUE);
      return helper(tri , 0 , 0 , dp);
    }
}