class Solution {
    public int cost(int i , int j, int arr[], int dp[][]){
        if(i>j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k = i; k<=j; k++){
            int len = arr[j+1] - arr[i-1];
            int tc = cost(i,k-1,arr, dp) + cost(k+1,j,arr, dp) + len;
            min = Math.min(min , tc);
        }
        return dp[i][j] = min;
    }
    public int minCost(int n, int[] cuts) {
        int cuts2[] = new int[cuts.length + 2];
        int dp[][] = new int[cuts2.length-1][cuts2.length-1];
        for(int arr[] : dp) Arrays.fill(arr,-1);
        cuts2[0] = 0; cuts2[cuts2.length-1] = n;
        for(int i = 1; i<cuts2.length-1; i++){
            cuts2[i] = cuts[i-1];
        }
        Arrays.sort(cuts2);
        return cost(1,cuts2.length-2,cuts2, dp);
    }
}