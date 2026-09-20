class Solution {
    public int check(int[] arr , int w){
        int d = 1;
        int w2  = w;
        for(int i = 0; i<arr.length; i++){
            if(w2<=0 || w2 < arr[i]){
                d++;
                w2 = w; 
            }
            w2 -= arr[i];
        }
        return d;
    }
    public int shipWithinDays(int[] arr, int days) {
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
        int ans = Integer.MAX_VALUE;
        while(i<=j){
            int mid = i + (j-i)/2;
            if(check(arr,mid) > days){
                i = mid+1;
            }
            else{
                ans = Math.min(ans,mid);
                j = mid-1;
            }
        }
        return ans;
    }
}