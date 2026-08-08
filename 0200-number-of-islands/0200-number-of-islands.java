class Solution {
    class Pair{
        int i;
        int j;
        Pair(int r, int c){
            i = r;
            j = c;
        }
    }
    public void bfs(int i , int j , char[][] grid, boolean vis[][]){
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int n2 = grid[0].length;
        vis[i][j] = true;
        Pair p = new Pair(i,j);
        q.add(p);
        while(q.size() != 0){
            Pair t = q.remove();
            int r = t.i;
            int c = t.j;
            if(r < n-1 && grid[r+1][c]=='1' && !vis[r+1][c]){
                 q.add(new Pair(r+1,c));
                 vis[r+1][c]=true;
            }
            if(r > 0 && grid[r-1][c]=='1' && !vis[r-1][c]) {
                q.add(new Pair(r-1, c));
                vis[r-1][c]=true;
            }
            if(c < n2-1 &&grid[r][c+1]=='1' && !vis[r][c+1]) {
                q.add(new Pair(r, c+1));
                vis[r][c+1]=true;
            }
            if(c > 0 && grid[r][c-1]=='1' && !vis[r][c-1]){
                 q.add(new Pair(r, c-1));
                 vis[r][c-1]=true;
            }
        }
    }
    public int numIslands(char[][] grid) {
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
               if(grid[i][j] == '1' && vis[i][j] == false){
                bfs(i, j, grid, vis);
                count++;
               }
            }
        }
        return count;
    }
}