class Solution {
    public int hIndex(int[] arr) {
        int ans = 0;
        int i = 0;
        int j = arr.length;
        while(i<=j){
            int mid = i + (j-i)/2;
            int ct = 0;
            for(int k = 0; k<arr.length; k++){
                if(arr[k] >= mid) ct++;
            }
            if(ct >= mid) {
                ans = mid;
                i = mid +1;
            }
            else{
                j = mid-1;
            }
        }
        return ans;
    }
}