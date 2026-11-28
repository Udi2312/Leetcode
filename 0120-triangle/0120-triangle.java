class Solution {
    public int helper(List<List<Integer>> arr , int i, int j, int dp[][]){
        if(i == arr.size()){
            return 0;
        }
        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        int f = helper(arr , i+1, j, dp);
        int s = helper(arr , i+1, j+1, dp);
        return dp[i][j] = arr.get(i).get(j) + Math.min(f,s);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp[][] = new int[triangle.size()+1][triangle.size()+1];
        for(int arr[] : dp) Arrays.fill(arr,Integer.MAX_VALUE);
        return helper(triangle , 0 , 0, dp);
    }
}