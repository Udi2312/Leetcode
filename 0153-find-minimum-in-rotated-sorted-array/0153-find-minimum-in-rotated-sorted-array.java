class Solution {
    public int findMin(int[] nums) {
        int i = 1;
        int j = nums.length-1;
        if(nums[0] <= nums[nums.length-1]) return nums[0];
        while(i<=j){
            int mid = i+(j-i)/2;
            if(nums[mid] < nums[mid-1]) return nums[mid];
            else if(nums[mid] > nums[mid-1] && nums[mid] > nums[j]) i = mid+1;
            else j = mid-1;
        }
        return -1;
    }
}