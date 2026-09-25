class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i<strs[0].length(); i++){
            char c = strs[0].charAt(i);
            boolean flag = true;
            for(int j = 1; j<strs.length; j++){
                if(i>= strs[j].length() || c != strs[j].charAt(i)) flag = false;
            }
            if(flag){
                sb.append(c);
            } 
            else break;
        }
        return sb.toString();
    }
}