class Solution {
    public int majorityElement(int[] nums) {
        int f = 1;
        int ans = nums[0];
        for(int i = 1; i<nums.length; i++){
            if(f==0){
                ans = nums[i];
            }
            if(ans == nums[i]) f++;
            else f--;

        }
        return ans;
    }
}