class Solution {
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int removeElement(int[] nums, int val) {
        int ct = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == val){
                nums[i] = -1;
                ct++;
            }
        }
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        while(i<=j){
            swap(nums,i,j);
            i++;
            j--;
        }
        return nums.length-ct;
    }
}