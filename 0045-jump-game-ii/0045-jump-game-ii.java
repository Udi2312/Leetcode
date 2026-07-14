class Solution {
    public int jump(int[] nums) {
       int  l = 0, r = 0, jumps = 0;
       while(r < nums.length-1){
        int fur = 0;
        for(int i = l; i<=r; i++){
            fur = Math.max(fur , i+nums[i]);
        }
        l = r+1;
        r = fur;
        jumps++;
       }
       return jumps;
    }
}