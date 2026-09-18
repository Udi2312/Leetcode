class Solution {
    public long hours(int[] arr , int h){
        long ans = 0;
        for(int i = 0; i<arr.length; i++){
            ans += (arr[i] + (long) h - 1) / h;
        }
        return ans;
    }
    public int minEatingSpeed(int[] arr, int ho) {
        int sum = 0;
        int max = -1;
        for(int num : arr){
            sum += num;
            if(num > max) max = num;
        }
        int l = 1;
        int h = max;
        int ans = -1;
        while(l<=h){
            int mid = (h-l)/2 + l;
            long currans = hours(arr,mid);
            if(currans <= ho){
                ans = mid;
                h = mid-1;
            }
            else{
                l = mid + 1;
            }
        }
        return ans;
    }
}