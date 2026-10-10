class Solution {
    public boolean helper(String s , List<String> words, int i, Boolean dp[]){
        if(i >= s.length()) return true;
        if(dp[i] != null) return dp[i];
        for(String word : words){
            if(s.startsWith(word , i)){
                if(helper(s , words , i + word.length(), dp)) return dp[i] = true;
            }
        }
        return dp[i] = false;
    }
    public boolean wordBreak(String s, List<String> word) {
        Boolean dp[] = new Boolean[s.length()+1];
        return helper(s , word, 0, dp);
    }
}
