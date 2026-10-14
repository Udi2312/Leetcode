class Solution {
    public int findMinArrowShots(int[][] arr) {
        if(arr.length == 0) return 0;
        Arrays.sort(arr , (a,b) -> {
            if(a[1] == b[1]) return Integer.compare(a[0] , b[0]); 
            return Integer.compare(a[1] , b[1]);
        });
        int ans = 1;
        int end = arr[0][1];
        for(int i = 1; i<arr.length; i++){
            if(arr[i][0] <= end) continue;
            else{
                ans++;
                end = arr[i][1];
            }
        }
        return ans;
    }
}