class Solution {
    class Pair{
        int r;
        int c;
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public void bfs(char[][] grid, int i, int j, boolean[][] vis){
        vis[i][j] = true;
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        while(q.size() > 0){
            Pair front = q.remove();
            int r = front.r;
            int c = front.c;
            if(r > 0){
                if(grid[r-1][c] == '1' && !vis[r-1][c]){
                    vis[r-1][c] = true;
                    q.add(new Pair(r-1,c));
                }
            }
            if(c > 0){
                if(grid[r][c-1] == '1' && !vis[r][c-1]){
                    vis[r][c-1] = true;
                    q.add(new Pair(r,c-1));
                }
            }
            if(r < m-1){
                if(grid[r+1][c] == '1' && !vis[r+1][c]){
                    vis[r+1][c] = true;
                    q.add(new Pair(r+1,c));
                }
            }
            if(c < n-1){
                if(grid[r][c+1] == '1' && !vis[r][c+1]){
                    vis[r][c+1] = true;
                    q.add(new Pair(r,c+1));
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        boolean[][] vis = new boolean[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    ans++;
                    bfs(grid , i, j, vis);
                }
            }
        }
        return ans;
    }
}