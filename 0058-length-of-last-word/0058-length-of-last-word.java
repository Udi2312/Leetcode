class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length()==0) return 0;
        String n = s.trim();
        int i = n.length()-1;
        int ans = 0;
        while(i>=0 && n.charAt(i) != ' '){
            ans++;
            i--;
        }
        return ans;
    }
}