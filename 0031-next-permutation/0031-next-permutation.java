class Solution {
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void rev(int[] arr, int i, int j){
        while(i<j){
            swap(arr,i,j);
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] nums) {
        int idx = -1;
        for(int i = nums.length-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                idx = i;
                break;
            }
        }
        if(idx==-1) rev(nums , 0, nums.length-1);
        else{
        for(int i = nums.length-1; i>idx; i--){
            if(nums[i] > nums[idx]){
                swap(nums,i,idx);
                break;
            } 
        }
        rev(nums,idx+1,nums.length-1);
        }
    }
}