class Solution {
    public int check(int[] arr, int maxpg){
        int st = 1;
        int pg = 0;
        for(int i = 0; i<arr.length; i++){
            if(pg + arr[i] <= maxpg){
                pg += arr[i];
            }
            else{
                st++;
                pg = arr[i];
            }
        }
        return st;
    }
    public int splitArray(int[] arr, int k) {
        int max = -1;
        for(int num : arr){
            if(num > max) max = num;
        }
        int i = max;
        int sum = 0;
        for(int num : arr){
            sum += num;
        }
        int j = sum;
        int ans = -1;
        while(i<=j){
            int mid = i + (j-i)/2;
            if(check(arr,mid) > k){
                i = mid+1;
            }
            else{
                ans = mid;
                j = mid-1;
            }
        }
        return ans;
    }
}