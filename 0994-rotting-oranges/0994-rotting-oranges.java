class Solution {
    class Pair{
        int r;
        int c;
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int rott = 0;
        int fre = 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 2){
                    rott++;
                    q.add(new Pair(i , j));
                }
                if(grid[i][j] == 1) fre++;
            }
        }
        while(q.size() > 0 && fre > 0){
            int currsize = q.size();
            for(int i = 0; i<currsize; i++){
                Pair p = q.remove();
                int r = p.r;
                int c = p.c;
            if(r>0){
                if(grid[r-1][c] == 1){
                    grid[r-1][c] = 2;
                    fre--;
                    q.add(new Pair(r-1,c));
                } 
            }
            if(c>0){
                if(grid[r][c-1] == 1){
                    grid[r][c-1] = 2;
                    fre--;
                    q.add(new Pair(r,c-1));
                } 
            }
            if(r+1 < m){
                if(grid[r+1][c] == 1){
                    grid[r+1][c] = 2;
                    fre--;
                    q.add(new Pair(r+1,c));
                } 
            }
            if(c+1 < n){
                if(grid[r][c+1] == 1){
                    grid[r][c+1] = 2;
                    fre--;
                    q.add(new Pair(r,c+1));
                } 
            }
            }
            ans++;
        }
        if(fre > 0) return -1;
        return ans;
    }
}