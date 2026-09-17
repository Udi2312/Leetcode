class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> fourSum(int[] arr, int target) {
       ans = new ArrayList<>();
       Arrays.sort(arr);
    //    int j = 1;
       int k = 2;
       int l = arr.length-1;
       for(int i = 0; i<arr.length-3; i++){
         if (i>0 && arr[i]==arr[i-1]){
                continue;
            }
       for(int j = i+1; j<arr.length-2; j++){
         if (j>i+1 && arr[j]==arr[j-1]){
                continue;
            }
             k = j+1;
             l = arr.length-1;
        while(l>k){
            long sum =(long) arr[i] + arr[j] + arr[k] + arr[l];
            if(sum > target) l--;
            else if(sum < target) k++;
            else{
                List<Integer> curr = new ArrayList<>();
                curr.add(arr[i]);
                curr.add(arr[j]);
                curr.add(arr[k]);
                curr.add(arr[l]);
                ans.add(curr);
                k++;
                l--;
                while(l>k && arr[k] == arr[k-1]) k++;
                while(l>k && arr[l] == arr[l+1]) l--;
            }
        }
       }
       } 
       return ans;
    }
    }