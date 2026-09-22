class Solution {
    public int[] productExceptSelf(int[] arr) {
        int pro = 1;
        int ans[] = new int[arr.length];
        for(int i = 0; i<arr.length; i++){
            ans[i] = pro;
            pro *= arr[i];
        }
        pro = 1;
        for(int i = arr.length-1; i>=0; i--){
            ans[i] *= pro;
            pro *= arr[i];
        }
        return ans;
    }
}