class Solution {
    public double helper(double x, long n){
        if(n == 0) return 1.0;
        double half = helper(x,n/2);
        if(n % 2 == 0) return half * half;
        else return half * half * x;
    }
    public double myPow(double x, int y) {
        long n = y;
        if(n < 0){
            if(x == 0) return 0;
            x = 1/x;
            n = -n;
        }
        return helper(x,n);
    }
}