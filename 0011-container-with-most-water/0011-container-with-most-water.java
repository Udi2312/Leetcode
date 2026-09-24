class Solution {
    public int maxArea(int[] arr) {
         int n = arr.length;
        int i = 0;
        int j = n-1;
        int ans = 0;
        while(i<j){
            ans = Math.max(ans , (j-i)* Math.min(arr[j] , arr[i]));
            if(arr[i] < arr[j]) i++;
            else j--;
        }
        return ans;
    }
}