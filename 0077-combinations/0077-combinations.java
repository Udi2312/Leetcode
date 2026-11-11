class Solution {
     List<List<Integer>> ans;
    public void helper(int[] arr , int i, int k, List<Integer> curr){
        if(k == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(i>=arr.length) return;
        curr.add(arr[i]);
        helper(arr , i+1, k-1, curr);
        curr.remove(curr.size()-1);
        helper(arr , i+1, k, curr);
    }
    public List<List<Integer>> combine(int n, int k) {
        int arr[] = new int[n];
        ans = new ArrayList<>();
        for(int i = 1; i<=n; i++) arr[i-1] = i;
        helper(arr , 0, k, new ArrayList<>());
        return ans;
    }
}