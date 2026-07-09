class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void helper(int k , int n , int i, List<Integer> curr){
        if(k==0 && n ==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(i>9|| k<0 || n<0){
            return;
        }
        curr.add(i);
        helper(k-1,n-i,i+1,curr);
        curr.remove(curr.size()-1);
         helper(k,n,i+1,curr);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(k , n , 1, new ArrayList<>());
        return ans;
    }
}