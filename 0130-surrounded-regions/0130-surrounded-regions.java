class Solution {
    class Pair{
        int r;
        int c;
        Pair(int r , int c){
            this.r = r;
            this.c = c;
        }
    }
    public void bfs(char[][] mat , boolean[][] vis , int i, int j){
        vis[i][j] = true;
        int n = mat.length;
        int m = mat[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        while(q.size() > 0){
            Pair p = q.remove();
            int r = p.r;
            int c = p.c;
            if(r > 0){
                if(mat[r-1][c] == 'O' && !vis[r-1][c]){
                    vis[r-1][c] = true;
                    q.add(new Pair(r-1,c));
                }
            }
            if(c > 0){
                if(mat[r][c-1] == 'O' && !vis[r][c-1]){
                    vis[r][c-1] = true;
                    q.add(new Pair(r,c-1));
                }
            }
            if(r < n-1){
                if(mat[r+1][c] == 'O' && !vis[r+1][c]){
                    vis[r+1][c] = true;
                    q.add(new Pair(r+1,c));
                }
            }
            if(c < m-1){
                if(mat[r][c+1] == 'O' && !vis[r][c+1]){
                    vis[r][c+1] = true;
                    q.add(new Pair(r,c+1));
                }
            }
        }
    }
    public void solve(char[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        boolean[][] vis = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){
        if(i == 0 || i == rows - 1 || j == 0 || j == cols - 1){
            if(mat[i][j] == 'O'){
                bfs(mat , vis , i , j);
            }
        }
    }
}
    for(int i = 0; i<rows; i++){
        for(int j = 0; j<cols; j++){
            if(mat[i][j] == 'O' && !vis[i][j]) mat[i][j] = 'X';
        }
    }
    }
}