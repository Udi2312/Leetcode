class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int arr[] = new int[m+n];
        int i = 0; int j = 0; int k = 0;
        while(i<m && j<n){
            if(nums1[i] < nums2[j]){
                arr[k++] = nums1[i++];
            }
            else if(nums1[i] > nums2[j]){
                arr[k++] = nums2[j++];
            }
            else{
                arr[k++] = nums1[i++];
                arr[k++] = nums2[j++];
            }
        }
        if(i<m){
            while(i<m){
                arr[k++] = nums1[i++];
            }
        }
        if(j<n){
            while(j<n){
                arr[k++] = nums2[j++];
            }
        }
        for(int l = 0; l<m+n; l++){
            nums1[l] = arr[l];
        }
    }
}