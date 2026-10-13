class Solution {
     public int[][] merge(int[][] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();
        ans.add(new int[]{arr[0][0] , arr[0][1]});
        for(int i = 1; i<arr.length; i++){
            if(arr[i][0] <= ans.get(ans.size()-1)[1]){
                ans.get(ans.size()-1)[0] = Math.min(ans.get(ans.size()-1)[0] , arr[i][0]);
                ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1] , arr[i][1]);
            }
            else{
                ans.add(new int[]{arr[i][0] , arr[i][1]});
            }
        }
        return ans.toArray(new int[ans.size()][]);
     }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        for(int arr[] : intervals){
            ans.add(arr);
        }
        ans.add(newInterval);
        return merge(ans.toArray(new int[ans.size()][]));
    }
}