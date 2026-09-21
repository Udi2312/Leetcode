class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
               HashMap<String , List<String>> mp = new HashMap<>();
       for(int i = 0; i<strs.length; i++){
        char[] ch = strs[i].toCharArray();
        Arrays.sort(ch);
        String s = new String(ch);
        mp.putIfAbsent(s , new ArrayList<>());
        mp.get(s).add(strs[i]);
       }
       return new ArrayList<>(mp.values());
    }
}