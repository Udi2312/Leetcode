class Solution {
    class Pair{
        int r;
        int c;
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    int islandID[][];
    HashMap<Integer , Integer> mp2;
    int uniId = 1;

    public int bfs(int[][] grid, int i , int j , boolean vis[][]){
        int n = grid.length;
         uniId += 1;
        islandID[i][j] = uniId;
         vis[i][j] = true;
         int sz = 1;
         Queue<Pair> q = new LinkedList<>();
         q.add(new Pair(i,j));
         while(q.size() > 0){
            Pair p = q.remove();
            int r = p.r;
            int c = p.c;
            if(r > 0){
                if(grid[r-1][c] == 1 && !vis[r-1][c]){
                    vis[r-1][c] = true;
                    islandID[r-1][c] = uniId;
                    sz++;
                    q.add(new Pair(r-1,c));
                }
            }
            if(c > 0){
                if(grid[r][c-1] == 1 && !vis[r][c-1]){
                    vis[r][c-1] = true;
                    islandID[r][c-1] = uniId;
                    sz++;
                    q.add(new Pair(r,c-1));
                }
            }
            if(r < n-1){
                if(grid[r+1][c] == 1 && !vis[r+1][c]){
                    vis[r+1][c] = true;
                    islandID[r+1][c] = uniId;
                    sz++;
                    q.add(new Pair(r+1,c));
                }
            }
            if(c < n-1){
                if(grid[r][c+1] == 1 && !vis[r][c+1]){
                    vis[r][c+1] = true;
                    islandID[r][c+1] = uniId;
                    sz++;
                    q.add(new Pair(r,c+1));
                }
            }
         }
         mp2.put(uniId , sz);
         return sz;
    }
    public int largestIsland(int[][] grid) {
        mp2 = new HashMap<>();
        int ans = 0;
        uniId = 1;
        int n = grid.length;
        islandID = new int[n][n];
        boolean vis[][] = new boolean[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                   int sz = bfs(grid , i , j , vis);
                   ans = Math.max(ans , sz);
                }
            }
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 0){
                    int sum = 0;
                    HashSet<Integer> st = new HashSet<>();
                    if(i > 0){
                            if(grid[i-1][j] == 1){
                            int id = islandID[i-1][j];
                            if(st.add(id)) sum += mp2.get(id);
                            }
                    }
                    if(j > 0){
                            if(grid[i][j-1] == 1){
                            int id = islandID[i][j-1];
                            if(st.add(id)) sum += mp2.get(id);
                            }
                    }
                    if(i < n-1){
                            if(grid[i+1][j] == 1){
                            int id = islandID[i+1][j];
                            if(st.add(id)) sum += mp2.get(id);
                            }
                    }
                    if(j < n-1){
                            if(grid[i][j+1] == 1){
                            int id = islandID[i][j+1];
                            if(st.add(id)) sum += mp2.get(id);
                            }
                    }
                    sum += 1;
                ans = Math.max(sum , ans);
                }
            }
        }
        if(ans == 0) return n * n;
        return ans;
    }
}