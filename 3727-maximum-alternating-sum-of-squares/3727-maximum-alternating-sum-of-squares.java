class Solution {
    public void swap(int arr[] , int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public long maxAlternatingSum(int[] nums) {
        for(int i = 0; i<nums.length; i++){
            if(nums[i] < 0) nums[i] = -nums[i];
        }
        Arrays.sort(nums);
        int i1 = 0;
        int j = nums.length-1;
        while(i1 < j){
            swap(nums , i1 , j);
            i1++;
            j--;
        }
        int neg = nums.length/2;
        int pos = nums.length - neg;
        long ans = 0;
        for(int i = 0; i<nums.length; i++){
            if(i <= pos-1){
                ans += (nums[i]*nums[i]);
            }
            else{
                ans -= (nums[i]*nums[i]);
            }
        }
        return ans;
    }
}