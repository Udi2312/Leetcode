class Solution {
    int parent[];
    int size[];
    public int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
    public void union(int a , int b){
        a = find(a);
        b = find(b);
        if(size[a] > size[b]){
            parent[b] = a;
            size[a] += size[b];
        }
        else{
            parent[a] = b;
            size[b] += size[a];
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        parent = new int[accounts.size()];
        size = new int[accounts.size()];
        for(int i = 0; i < accounts.size(); i++){
            parent[i] = i;
            size[i] = 1;
        }
        HashMap<String , Integer> mp = new HashMap<>();
        for(int j = 0; j<accounts.size(); j++){
            for(int i = 1; i<accounts.get(j).size(); i++){
                if(!mp.containsKey(accounts.get(j).get(i))){
                    mp.put(accounts.get(j).get(i) , j);
                }
                else{
                    union(j , mp.get(accounts.get(j).get(i)));
                }
            }
        }
        List<List<String>> merged = new ArrayList<>();
        for(int i = 0; i<accounts.size(); i++) merged.add(new ArrayList<>());
        for(String mail : mp.keySet()){
            int leader = find(mp.get(mail));
            merged.get(leader).add(mail);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i<accounts.size(); i++){
            if(merged.get(i).size() == 0) continue;
            Collections.sort(merged.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String s : merged.get(i)){
                temp.add(s);
            }
            ans.add(temp);
        }
        return ans;
    }
}