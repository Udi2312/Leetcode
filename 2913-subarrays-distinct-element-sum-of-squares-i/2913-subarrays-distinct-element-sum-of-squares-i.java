class Solution {
    int ans;
    public void helper(int arr[] , int i, int j){
        int dis = 0;
        HashSet<Integer> st = new HashSet<>();
        for(int k = i; k<=j; k++){
            st.add(arr[k]);
        }
        ans += (st.size() * st.size());
    }
    public int sumCounts(List<Integer> nums) {
        ans = 0;
        int arr[] = new int[nums.size()];
        for(int i = 0; i<nums.size(); i++){
            arr[i] = nums.get(i);
        }
        for(int i = 0; i<arr.length; i++){
            for(int j = i; j<arr.length; j++){
                helper(arr , i , j);
            }
        }
        return ans;
    }
}