class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> mp = new HashMap<>();
        if(s.length() != t.length()) return false;
        char sa[] = s.toCharArray();
        char ta[] = t.toCharArray();
        for(char c : sa){
            mp.put(c , mp.getOrDefault(c,0) + 1);
        }
        for(char c : ta){
            if(!mp.containsKey(c)) return false;
            else{
                int freq = mp.get(c);
                if(freq <= 0) return false;
                mp.put(c , freq-1);
            }
        }
        return true;
    }
}