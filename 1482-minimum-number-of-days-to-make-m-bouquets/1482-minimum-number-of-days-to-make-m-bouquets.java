class Solution {
    public boolean check(int[] arr, int num, int m, int k){
        int d = 0;
        int co = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] <= num){
                co++;
            }
            else{
                d += co/k;
                co = 0;
            }
        }
        d += co/k;
        if(d >= m) return true;
        return false;
    }
    public int minDays(int[] arr, int m, int k) {
        if(m*k > arr.length) return -1;
        int min = Integer.MAX_VALUE;
        for(int num : arr){
            if(num < min) min = num;
        }
        int max = Integer.MIN_VALUE;
        for(int num : arr){
            if(num > max) max = num;
        }
        int i = min;
        int j = max;
        int ans = -1;
        while(i<=j){
            int mid = i + (j-i)/2;
            if(check(arr,mid,m,k)){
                ans = mid;
                j = mid-1;
            }
            else{
                i = mid +1;
            }
        }
        return ans;
    }
}