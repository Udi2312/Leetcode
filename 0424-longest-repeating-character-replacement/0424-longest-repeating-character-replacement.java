class Solution {
    public int characterReplacement(String s, int k) {
        int frearr[] = new int[26];
        int l = 0;
        int maxfre = 0;
        int ans = 0;
        for(int i = 0; i<s.length(); i++){
            frearr[s.charAt(i)-'A']++;
            maxfre = Math.max(maxfre , frearr[s.charAt(i)-'A']);
            while(k < i-l+1-maxfre){
                frearr[s.charAt(l)-'A']--;
                l++;
            }
            ans = Math.max(ans , i-l+1);
        }
        return ans;
    }
}