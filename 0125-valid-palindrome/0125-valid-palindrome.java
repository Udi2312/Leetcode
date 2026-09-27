class Solution {
    public boolean isPalindrome(String s) {
        String n = s.toLowerCase();
        if(n.equals("")) return true;
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            while(i<j && !Character.isLetterOrDigit(n.charAt(i))){
                i++;
            }
            while(i<j && !Character.isLetterOrDigit(n.charAt(j))){
                j--;
            }
            if(n.charAt(i) != n.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}