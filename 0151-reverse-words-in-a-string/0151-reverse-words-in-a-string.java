class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder("");
        String ans = "";
        for(int i = s.length()-1; i>=0; i--){
            if(s.charAt(i) != ' ') sb.append(s.charAt(i));
            else{
                sb.reverse();
                ans += sb;
                ans += " ";
                sb = new StringBuilder("");
            }
        }
        sb.reverse();
        ans += sb;
        ans = ans.strip();
        ans = ans.replaceAll("\\s+", " "); 
        return ans;
    }
}