class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> threeSum(int[] arr) {
        ans = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);
        int i = 0;
        while(i < n-2){
        int j = i+1;
        int k = n-1;
            while(j<k){
            if(arr[i] + arr[j] + arr[k] == 0){
                List<Integer> curr = new ArrayList<>();
                curr.add(arr[i]);
                curr.add(arr[j]);
                curr.add(arr[k]);
                ans.add(curr);
                j++;
                while(j < n && arr[j] == arr[j-1]) j++;
                k--;
                while(j < k && arr[k] == arr[k+1]) k--;
            }
            else if(arr[i] + arr[j] + arr[k] < 0){
                j++;
            }
            else k--;
            }
            i++;
            while(i < n && arr[i] == arr[i-1]) i++;
        }
        return ans;
    }
}