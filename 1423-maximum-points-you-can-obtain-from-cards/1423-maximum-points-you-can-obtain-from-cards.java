class Solution {
    public int maxScore(int[] arr, int k) {
      int ridx = arr.length-1;
      int lidx = 0;
      int ans = 0;
      int lsum = 0;
      int rsum = 0;
      for(int i = lidx; i<k; i++){
        lsum += arr[i];
      }
      ans =  lsum;
      for(int i = k-1; i>=0; i--){
        lsum -= arr[i];
        rsum += arr[ridx];
        ridx--;
        ans = Math.max(ans , lsum + rsum);
      }
      return ans;
    }
}