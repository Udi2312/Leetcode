class Solution {
    public int minRotations(String s) {
        int ans = 0;
        int i = 0;
        int j = 1;
        int fir = s.charAt(i)-'0';
        if(fir < 5) ans += fir;
        else ans += 10-fir;
        while(j < s.length()){
            int rot = 0;
            int ri = 0;
            int rj = 0;
            if(s.charAt(i)-'0' < 5) ri = Math.abs(0-s.charAt(i)-'0');
            else if(s.charAt(i)-'0' >= 5) ri = Math.abs(10-s.charAt(i)-'0');
            if(s.charAt(j)-'0' < 5) rj = Math.abs(0-s.charAt(j)-'0');
            else if(s.charAt(j)-'0' >= 5) rj = Math.abs(10-s.charAt(j)-'0');
            ans += Math.min(Math.abs((s.charAt(i)-'0') - (s.charAt(j)-'0'))  , Math.abs(ri - rj));
            i++;
            j++;
        }
        return ans;
    }
}