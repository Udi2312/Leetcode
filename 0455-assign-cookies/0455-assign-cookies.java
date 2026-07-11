class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int i = 0;
        int j = 0;
        int ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        
        while(j < s.length && i < g.length){
            if(g[i] <= s[j]){
                ans++;
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return ans;
    }
}