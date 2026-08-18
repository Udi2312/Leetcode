class Solution {
    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public int[][] floodFill(int[][] grid, int sr, int sc, int color) {
        int a = grid[sr][sc];
        grid[sr][sc] = color;
        if(a==color) return grid;
        int n = grid.length;
        int n2 = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        while(q.size() > 0){
            Pair p = q.remove();
            int r = p.i; 
            int c = p.j;
            if(r < n-1 && grid[r+1][c]==a){
                grid[r+1][c] = color;
                 q.add(new Pair(r+1,c));
            }
            if(r > 0 && grid[r-1][c]==a) {
                grid[r-1][c] = color;
                q.add(new Pair(r-1, c));
                // vis[r-1][c]=true;
            }
            if(c < n2-1 &&grid[r][c+1]==a) {
                grid[r][c+1] = color;
                q.add(new Pair(r, c+1));
                // vis[r][c+1]=true;
            }
            if(c > 0 && grid[r][c-1]==a){
                grid[r][c-1] = color;
                 q.add(new Pair(r, c-1));
                //  vis[r][c-1]=true;
            }
        }
        return grid;
    }
}