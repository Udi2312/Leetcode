class Solution {
    public int lowerbound(int[] nums ,int x){
        int i = 0;
        int j = nums.length-1;
        int ans = nums.length;
        while(i<=j){
            int mid = i + (j-i)/2;
            if(nums[mid] >= x){
                ans = mid;
                j = mid-1;
            }
            else i = mid+1;
        }
        return ans;
    }

    public int upperbound(int[] nums ,int x){
        int i = 0;
        int j = nums.length-1;
        int ans = nums.length;
        while(i<=j){
            int mid = i + (j-i)/2;
            if(nums[mid] > x){
                ans = mid;
                j = mid-1;
            }
            else i = mid+1;
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        int lb = lowerbound(nums , target);
        if(lb == nums.length || nums[lb] != target) return ans;
        else{
            ans[0] = lb;
            ans[1] = upperbound(nums,target)-1;
            return ans;
        }
    }
}