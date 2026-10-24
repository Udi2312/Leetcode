class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        List<String> ans = new ArrayList<>();
        int start[] = new int[26];
        int end[] = new int[26];
        Arrays.fill(start, -1);
        Arrays.fill(end, -1);
        for(int i = 0; i<s.length(); i++){
            int idx = s.charAt(i) - 'a';
            if(start[idx] == -1){
                start[idx] = i;
            }
            end[idx] = i;
        }
        boolean valid[] = new boolean[26];
        Arrays.fill(valid , true);
        for(int i = 0; i<26; i++){
            if(start[i] == -1) continue;
            for(int j = start[i]; j<end[i]; j++){
                if(start[s.charAt(j) - 'a'] < start[i]){
                    valid[i] = false;
                    break;
                }
                end[i] = Math.max(end[s.charAt(j) - 'a'] , end[i]);
            }
        }
        int last = Integer.MAX_VALUE;
        for(int i = s.length()-1; i>=0; i--){
            int idx = s.charAt(i) - 'a';
            if(valid[idx] && (i == start[idx]) && (end[idx] < last)){
                ans.add(s.substring(i , end[idx] + 1));
                last = i;
            }
        }
        return ans;
    }
}