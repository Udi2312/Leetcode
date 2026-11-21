class Solution {
    public int findPeakElement(int[] arr) {
        int i = 1;
        int n = arr.length;
        int j = n-2;
        if(n == 1) return 0;
        if(arr[0] > arr[1]) return 0;
        if(arr[n-1] > arr[n-2]) return n-1;
        while(i<=j){
            int mid = i +(j-i)/2;
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) return mid;
            else if(arr[mid] > arr[mid-1]) i = mid+1;
            else j = mid-1;
        }
        return -1;
    }
}