class Solution {
    public int check(int arr[] , int num){
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            sum += Math.ceil((double)arr[i]/num);
        }
        return sum;
    }
    public int smallestDivisor(int[] arr, int th) {
        int i = 1;
        int max = Integer.MAX_VALUE;
        for(int num: arr){
            if(num > max) max = num;
        }
        int j = max;
        int ans = Integer.MAX_VALUE;
        while(i<=j){
            int mid = i + (j-i)/2;
            if(check(arr,mid) > th){
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