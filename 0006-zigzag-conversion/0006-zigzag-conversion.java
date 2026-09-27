class Solution {
    public String convert(String s, int n) {
        if(n == 1) return s;
        StringBuilder sb = new StringBuilder("");
        for(int r = 0; r<n; r++){
            int inc = (n-1) * 2;
            for(int i = r; i<s.length(); i += inc){
                sb.append(s.charAt(i));
                if(r > 0 && r < n-1 && i + inc - 2*r < s.length()){
                    sb.append(s.charAt(i + inc - 2*r));
                }
            }
        }
        return sb.toString();
    }
}