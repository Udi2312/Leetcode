class Solution {
    public int findPeakElement(int[] arr) {
        int i = 0;
        int n = arr.length;
        int j = n-1;
        while(i<j){
            int mid = i + (j-i)/2;
            if(arr[mid+1] > arr[mid]) i = mid+1;
            else j = mid;
        }
        return i;
    }
}