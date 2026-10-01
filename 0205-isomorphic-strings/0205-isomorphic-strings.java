class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character , Character> mp = new HashMap<>();
        boolean flag = true;
        for(int i = 0; i<s.length(); i++){
            char sh = s.charAt(i);
            char th = t.charAt(i);
            if(mp.containsValue(th) && !mp.containsKey(sh)) return false;
            if(mp.containsKey(sh)){
               flag =( mp.get(sh) == th );
               if(!flag) return false;
            }
            else{
                mp.put(sh,th);
            }
        }
        return flag;
    }
}