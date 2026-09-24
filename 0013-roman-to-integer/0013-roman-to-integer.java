class Solution {
    public int value(char c){
        if(c=='I') return 1;
        if(c=='V') return 5;
        if(c=='X') return 10;
        if(c=='L') return 50;
        if(c=='C') return 100;
        if(c=='D') return 500;
        if(c=='M') return 1000;
        return -1;
    }
    public int romanToInt(String s) {
        int ans = 0;
        for(int i = 0; i<s.length()-1; i++){
            int f = value(s.charAt(i));
            int se = value(s.charAt(i+1));
            if(f < se) ans += -(f);
            else{
                ans += f;
            }
        }
        ans += value(s.charAt(s.length()-1));
        return ans;
    }
}