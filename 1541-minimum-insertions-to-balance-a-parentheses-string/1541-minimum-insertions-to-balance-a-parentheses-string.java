class Solution {
    public int minInsertions(String s) {
        int ans = 0;
        int count = 0;
        int i = 0;
        while(i < s.length()) {
            char ch = s.charAt(i);
           if(ch == '('){
           i++;
           count++;
           }

           else{
            if(count > 0) count--;
            else ans++;

            if(i+1 < s.length() && s.charAt(i+1) == ')') i = i+2;
            else{
                i++;
            ans++;
            }
           }
        }
        return ans + 2*count;
    }
}