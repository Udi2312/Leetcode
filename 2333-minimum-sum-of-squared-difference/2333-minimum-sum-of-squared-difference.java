class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int countgap[] = new int[100001];
        for(int i = 0; i<nums1.length; i++){
            int diff = Math.abs(nums1[i] - nums2[i]);
            countgap[diff]++;
        }
        int sum = k1 + k2;
        for(int i = countgap.length-1; i>0 && sum > 0; i--){
            int countops = Math.min(countgap[i] , sum);
            countgap[i] -= countops;
            countgap[i-1] += countops;
            sum -= countops;
        }
        long res = 0;
        for(int i = 1; i<countgap.length; i++) res += (long) countgap[i] * i * i;;
        return res;
    }
}