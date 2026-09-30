class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character , Integer> mp = new HashMap<>();
        char m[] = magazine.toCharArray();
        char r[] = ransomNote.toCharArray();
        for(char c : m){
            mp.put(c , mp.getOrDefault(c,0) + 1);
        }
        for(char c : r){
            if(mp.containsKey(c)){
               int freq = mp.get(c);
               if(freq <= 0) return false;
               else{
                freq--;
                mp.put(c,freq);
               }
            }
            else{
                return false;
            }
        }
        return true;
    }
}