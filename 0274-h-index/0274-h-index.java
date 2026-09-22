class Solution {
    public int hIndex(int[] arr) {
        Arrays.sort(arr);
        int ans = arr[0];
        int i = 1;
        int j = arr[arr.length-1];
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