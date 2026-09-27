class Solution {
    public int[] twoSum(int[] arr, int target) {
        int n = arr.length;
        int i = 0;
        int j = n-1;
        int ans[] = new int[2];
        Arrays.fill(ans,-1);
        while(i<=j){
            if(arr[i] + arr[j] == target){
                ans[0] = i+1;
                ans[1] = j+1;
                break;
            }
            if(target - arr[i] > arr[j]) i++;
            else if(target - arr[j] < arr[i]) j--;
        }
        return ans;
    }
}