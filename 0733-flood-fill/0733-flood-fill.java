class Solution {
    class Pair{
        int r;
        int c;
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public void bfs(int[][] grid, int sr, int sc, boolean[][] vis, int co){
        Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        vis[sr][sc] = true;
        int curr = grid[sr][sc];
        q.add(new Pair(sr ,sc));
        while(q.size() > 0){
            Pair p = q.remove();
            int r = p.r;
            int c = p.c;
            if(r>0){
                if(!vis[r-1][c] && grid[r-1][c] == curr){
                    grid[r-1][c] = co;
                    q.add(new Pair(r-1,c));
                    vis[r-1][c] = true;
                } 
            }
            if(c>0){
                if(!vis[r][c-1] && grid[r][c-1] == curr){
                    grid[r][c-1] = co;
                    q.add(new Pair(r,c-1));
                    vis[r][c-1] = true;
                } 
            }
            if(r+1 < m){
                if(!vis[r+1][c] && grid[r+1][c] == curr){
                    grid[r+1][c] = co;
                    q.add(new Pair(r+1,c));
                    vis[r+1][c] = true;
                } 
            }
            if(c+1 < n){
                if(!vis[r][c+1] && grid[r][c+1] == curr){
                    grid[r][c+1] = co;
                    q.add(new Pair(r,c+1));
                    vis[r][c+1] = true;
                } 
            }
        }
        grid[sr][sc] = co;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int co) {
        if(image[sr][sc] == co) return image;
        int m = image.length;
        int n = image[0].length;
        boolean[][] vis = new boolean[m][n];
        bfs(image , sr , sc , vis, co);
        return image;
    }
}