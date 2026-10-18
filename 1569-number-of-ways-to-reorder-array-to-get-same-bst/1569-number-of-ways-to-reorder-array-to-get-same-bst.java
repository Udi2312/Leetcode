class Solution {
    long mod = 1000000007L;
    List<List<Long>> pascal;
    public long solve(int nums[]){
        int n = nums.length;
        if(n<3) return 1;
        List<Integer> right = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        for(int i = 1; i<n; i++){
            if(nums[i] > nums[0]){
                right.add(nums[i]);
            }
            else{
                left.add(nums[i]);
            }
        }
        long x = solve(left.stream().mapToInt(i -> i).toArray());
        long y = solve(right.stream().mapToInt(i -> i).toArray());
        long z = pascal.get(n-1).get(left.size());

         long temp = (x*y) % mod;
         return (temp * z) % mod;
    }
    public int numOfWays(int[] nums) {
       int n = nums.length;
       pascal = new ArrayList<>();
       for (int i = 0; i <= n; i++) {
            List<Long> row = new ArrayList<>(
                Collections.nCopies(i + 1, 0L)
            );
            row.set(0, 1L);
            row.set(i, 1L);
            for (int j = 1; j < i; j++) {
                long val = (
                    pascal.get(i - 1).get(j)
                    + pascal.get(i - 1).get(j - 1)
                ) % mod;
                row.set(j, val);
            }
            pascal.add(row);
        }
        return (int) ((solve(nums) - 1 + mod) % mod);
    }
}