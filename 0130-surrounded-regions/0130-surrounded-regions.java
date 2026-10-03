class Solution {
    class Pair{
        int r;
        int c;
        Pair(int r , int c){
            this.r = r;
            this.c = c;
        }
    }
    public void bfs(char[][] grid , boolean[][] vis , int i , int j){
         int m = grid.length;
        int n = grid[0].length;
        vis[i][j] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        while(q.size() > 0){
            Pair p = q.remove();
            int r = p.r;
            int c = p.c;
            if(r>0){
                if(!vis[r-1][c] && grid[r-1][c] == 'O'){
                    q.add(new Pair(r-1,c));
                    vis[r-1][c] = true;
                } 
            }
            if(c>0){
                if(!vis[r][c-1] && grid[r][c-1] == 'O'){
                    q.add(new Pair(r,c-1));
                    vis[r][c-1] = true;
                } 
            }
            if(r+1 < m){
                if(!vis[r+1][c] && grid[r+1][c] == 'O'){
                    q.add(new Pair(r+1,c));
                    vis[r+1][c] = true;
                } 
            }
            if(c+1 < n){
                if(!vis[r][c+1] && grid[r][c+1] == 'O'){
                    q.add(new Pair(r,c+1));
                    vis[r][c+1] = true;
                } 
            }
        }
    }
    public void solve(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 'X') vis[i][j] = true;
            }
        }
        for(int i = 0; i<n; i++){
            if(grid[0][i] == 'O' && !vis[0][i]) bfs(grid , vis , 0 , i);
        }
        for(int i = 1; i<m; i++){
            if(grid[i][n-1] == 'O' && !vis[i][n-1]) bfs(grid , vis , i , n-1);
        }
        if(m > 1){
        for(int i = n-2; i>=0; i--){
            if(grid[m-1][i] == 'O' && !vis[m-1][i]) bfs(grid , vis , m-1 , i);
        }
        }
        if(n > 1){
        for(int i = m-2; i>0; i--){
            if(grid[i][0] == 'O' && !vis[i][0]) bfs(grid , vis , i , 0);
        }
        }
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(!vis[i][j]) grid[i][j] = 'X';
            }
        }
    }
}