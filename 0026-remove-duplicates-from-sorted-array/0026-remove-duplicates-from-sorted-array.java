class Solution {
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int removeDuplicates(int[] nums) {
        int ct = 0;
        for(int i = 1; i<nums.length; i++){
            if(nums[i] == nums[i-1]){
                nums[i-1] = -101;
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
        i = 0;
        j = nums.length-ct-1;
        while(i<=j){
            swap(nums,i,j);
            i++;
            j--;
        }
        return nums.length-ct;
    }
}