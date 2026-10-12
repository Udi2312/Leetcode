class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int bit[] = new int[32];
        for(int num : nums){
            for(int i = 0; i<32; i++){
                if((num & (1<<i)) != 0) bit[i]++;
            }
        }
        long res = 0;
        while(k > 0){
            long curr = 0;
            for(int i = 0; i<32; i++){
                if(bit[i] > 0){
                    bit[i]--;
                    curr = (curr | (1 << i));
                }
            }
            res = (res + (curr * curr)) % 1000000007;
            k--;
        }
        return (int)res;
    }
}