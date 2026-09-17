class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> threeSum(int[] arr) {
        ans = new ArrayList<>();
       Arrays.sort(arr);
    //    int i = 0;
       int j = 1;
       int k = arr.length-1;
       for(int i = 0; i<arr.length; i++){
         if (i>0 && arr[i]==arr[i-1]) {
                continue;
            }
             j = i+1;
             k = arr.length-1;
        while(k>j){
            int sum = arr[i] + arr[j] + arr[k];
            if(sum > 0) k--;
            else if(sum < 0) j++;
            else{
                List<Integer> curr = new ArrayList<>();
                curr.add(arr[i]);
                curr.add(arr[j]);
                curr.add(arr[k]);
                ans.add(curr);
                j++;
                k--;
                while(j<k && arr[j] == arr[j-1]) j++;
                while(j<k && arr[k] == arr[k+1]) k--;
            }
        }
       }
       return ans;
    }
}