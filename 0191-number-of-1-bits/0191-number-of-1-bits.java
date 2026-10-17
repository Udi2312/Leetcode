class Solution {
    public String helper(int n){
        StringBuilder sb = new StringBuilder("");
        while(n != 1){
            if(n % 2 == 1) sb.append("1");
            else sb.append("0");
            n = n/2;
        }
        return sb.reverse().toString();
    }
    public int hammingWeight(int n) {
        if(n == 0) return 0;
        String ans = helper(n);
        int co = 0;
        for(int i = 0; i<ans.length(); i++) if(ans.charAt(i) == '1') co++;
        return co+1;
    }
}
