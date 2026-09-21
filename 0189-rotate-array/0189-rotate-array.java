class Solution {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void rev(int[] nums, int i , int j){
        while(i<=j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        rev(nums,0,nums.length - k-1);
        rev(nums,nums.length - k ,nums.length-1);
        rev(nums,0,nums.length-1);
    }
}