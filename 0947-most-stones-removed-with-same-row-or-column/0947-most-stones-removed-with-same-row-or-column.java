class Solution {
    public void dfs(int[][] stones , int idx , boolean[] vis){
        vis[idx] = true;
        int n = stones.length;
        for(int i = 0; i<n; i++){
            if(!vis[i] && (stones[i][0] == stones[idx][0] || stones[i][1] == stones[idx][1])){
                dfs(stones , i , vis);
            }
        }
    }
    public int removeStones(int[][] stones) {
        int grp = 0;
        int n = stones.length;
        boolean vis[] = new boolean[n];
        for(int i = 0; i<n; i++){
            if(vis[i]) continue;
            dfs(stones , i , vis);
            grp++;
        }
        return n - grp;
        }
    }