class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();
        if(n == 0) return 0;
        while(i < n && s.charAt(i) == ' ') i++;
        int neg = 1;
        if(i < n && s.charAt(i) == '+'){
            neg = 1;
            i++;
        }
        else if(i < n && s.charAt(i) == '-'){
            neg = -1;
            i++;
        }
        while(i < n && s.charAt(i) == '0') i++;
        long sum = 0;
        while(i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            int dig = s.charAt(i)-'0';
            sum = sum * 10 + dig;
            if(sum > Integer.MAX_VALUE){
                if(neg == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int)sum*neg;
    }
}