class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.equals("")) return true;
        int i = 0;
        int j = 0;
        while(i<s.length()){
            char c = s.charAt(i);
            while(j<t.length() && t.charAt(j) != c) j++;
        if(j>=t.length()) return false;
            i++;
            j++;
        }
        return true; 
    }
}