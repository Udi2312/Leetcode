class Solution {
    public void helper(int[] nums , List<List<Integer>> ans, boolean isValid[], List<Integer> curr){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i<nums.length; i++){
           if(!isValid[i]){
            isValid[i] = true;
            curr.add(nums[i]);
            helper(nums , ans , isValid, curr);
            isValid[i] = false;
            curr.remove(curr.size()-1);
           }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean isValid[] = new boolean[nums.length];
        helper(nums , ans , isValid, new ArrayList<>());
        return ans;
    }
}