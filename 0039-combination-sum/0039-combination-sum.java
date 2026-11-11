class Solution {
    List<List<Integer>> ans;
    public void helper(int[] arr , int i, int k , List<Integer> curr){
        if(k == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(i >= arr.length || k<0) return;
        curr.add(arr[i]);
        helper(arr , i, k-arr[i], curr);
        curr.remove(curr.size()-1);
        helper(arr , i+1, k , curr);
    }
    public List<List<Integer>> combinationSum(int[] arr, int k) {
        ans = new ArrayList<>();
        helper(arr , 0 , k , new ArrayList<>());
        return ans;
    }
}