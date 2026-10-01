class Solution {
    public boolean wordPattern(String pattern, String s) {
        String sn[] = s.split(" ");
        if(pattern.length() != sn.length) return false;
        HashMap<Character , String> mp = new HashMap<>();
        boolean flag = true;
        for(int i = 0; i<pattern.length(); i++){
            char sh = pattern.charAt(i);
            String th = sn[i];
            if(mp.containsValue(th) && !mp.containsKey(sh)) return false;
            if(mp.containsKey(sh)){
               flag =( mp.get(sh).equals(th) );
               if(!flag) return false;
            }
            else{
                mp.put(sh,th);
            }
        }
        return flag;
    }
}