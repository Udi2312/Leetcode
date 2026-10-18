class Solution {
    public void helper(int[] nums , List<List<Integer>> ans, int i, List<Integer> curr){
        if(i == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        helper(nums , ans , i+1, curr);
        curr.remove(curr.size()-1);
        helper(nums, ans , i+1, curr);
    }
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums , ans , 0, new ArrayList<>());
        return ans;
    }
}