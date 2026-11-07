class Solution {
    class Pair{
        String s;
        double d;
        Pair(String s, double d){
            this.s = s;
            this.d = d;
        }
    }
    public double dfs(Map<String , List<Pair>> adj, String src, String des, HashSet<String> vis){
        if(!adj.containsKey(src) || !adj.containsKey(des)) return -1.0;
        if(src.equals(des)) return 1.0;
        vis.add(src);
        for(Pair p : adj.get(src)){
            if(!vis.contains(p.s)){
                double res = dfs(adj , p.s, des, vis);
                if(res != -1.0){
                   return p.d * res;
                }
            }
        }
        return -1.0;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        Map<String , List<Pair>> adj = new HashMap<>();
        for(int i = 0; i<n; i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];
            adj.putIfAbsent(u , new ArrayList<>());
            adj.putIfAbsent(v , new ArrayList<>());
            adj.get(u).add(new Pair(v , val));  
            adj.get(v).add(new Pair(u , 1.0/val)); 
        }
        double[] res = new double[queries.size()];
        int k = 0;
        for(List<String> s : queries){
            String src = s.get(0);
            String des = s.get(1);
            HashSet<String> vis = new HashSet<>();
            res[k++] = dfs(adj , src , des, vis);
        }
        return res;
    }
}