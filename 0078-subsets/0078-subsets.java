class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        int sub = 1 << n;
        for(int i = 0; i<sub; i++){
        List<Integer> l = new ArrayList<>();
            for(int j = 0; j<n; j++){
            if((i & (1<<j)) != 0) l.add(nums[j]);
            }
            ans.add(l);
        }
        return ans;
    }
}