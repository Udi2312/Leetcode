class Solution {
    public int strStr(String s, String t) {
        int i = 0;
        int j = 0;
        int k = 0;
        int ans = -1;
        while(i < s.length()){
            while(i < s.length() && j < t.length() && s.charAt(i) != t.charAt(j)){
                i++;
            }
            if(i>=s.length()) return -1;
            ans = i;
            while(i < s.length() && j < t.length() && s.charAt(i) == t.charAt(j)){
                i++;
                j++;
                k++;
            }
            if(j >= t.length()) return ans;
            if(i >= s.length()) return -1;
            if(i < s.length() && j < t.length() && s.charAt(i) != t.charAt(j)){
                j = 0;
                ans = -1;
                i = i-k+1;
                k = 0;
            }
        }
        return ans;
    }
}