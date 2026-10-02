class Solution {
    public void helper(int[] nums , int idx , List<String> ans){
        if(idx == nums.length) return;
        StringBuilder sb = new StringBuilder("");
        int j = idx;
        while(j+1 < nums.length && nums[j+1] == nums[j] +1) j++;
        if(idx == j) sb.append(nums[idx]);
        else{
            sb.append(nums[idx]);
            sb.append("->");
            sb.append(nums[j]);
        }
        ans.add(sb.toString());
        helper(nums,j+1,ans);
    }
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        helper(nums , 0 ,ans);
        return ans;
    }
}