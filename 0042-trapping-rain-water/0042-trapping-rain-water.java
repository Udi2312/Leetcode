class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int premax[] = new int[n];
        int suffmax[] = new int[n];
        premax[0] = arr[0];
        for(int i = 1; i<n; i++){
            premax[i] = Math.max(premax[i-1] , arr[i]);
        }
        suffmax[n-1] = arr[n-1];
        for(int i = n-2; i>=0; i--){
            suffmax[i] = Math.max(suffmax[i+1] , arr[i]);
        }
        int ans = 0;
        for(int i = 0; i<n; i++){
            ans += Math.min(premax[i] , suffmax[i]) - arr[i];
        }
        return ans;
    }
}