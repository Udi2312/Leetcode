class Solution {
    public int countSquares(int[][] arr) {
        for(int i = 1; i<arr.length; i++){
            for(int j = 1; j<arr[0].length; j++){
               if(arr[i][j] == 1) arr[i][j] += Math.min(Math.min(arr[i-1][j] , arr[i][j-1]), arr[i-1][j-1]);
            }
        }
        int ans = 0;
        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr[0].length; j++){
                ans += arr[i][j];
            }
        }
        return ans;
    }
}