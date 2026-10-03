class Solution {
    class Pair{
        int r;
        int c;
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public boolean[][] bfs(int[][] grid, Queue<Pair> q){
        int m = grid.length;
        int n = grid[0].length;
        boolean ans[][] = new boolean[m][n];
        while(q.size() > 0){
            Pair p = q.remove();
            int r = p.r;
            int c = p.c;
            ans[r][c] = true;
            if(r>0){
                if(grid[r-1][c] >= grid[r][c] && !ans[r-1][c]){
                    ans[r-1][c] = true;
                    q.add(new Pair(r-1,c));
                }     
            }
            if(c>0){
                if(grid[r][c-1] >= grid[r][c] && !ans[r][c-1]){
                    q.add(new Pair(r,c-1));
                    ans[r][c-1] = true;
                }     
            }
            if(r+1 < m){
                if(grid[r+1][c] >= grid[r][c] && !ans[r+1][c]){
                    q.add(new Pair(r+1,c));
                    ans[r+1][c] = true;
                }     
            }
            if(c+1<n){
                if(grid[r][c+1] >= grid[r][c] && !ans[r][c+1]){
                    q.add(new Pair(r,c+1));
                    ans[r][c+1] = true;
            }
        }
    }
    return ans;
    }
    public List<List<Integer>> pacificAtlantic(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Pair> pac = new LinkedList<>();  
        Queue<Pair> atl = new LinkedList<>();
        for(int i = 0; i<n; i++){
            pac.add(new Pair(0,i));
        }
        for(int i = 0; i<m; i++){
            pac.add(new Pair(i,0));
        }
        for(int i = 0; i<n; i++){
            atl.add(new Pair(m-1,i));
        }
        for(int i = 0; i<m; i++){
            atl.add(new Pair(i,n-1));
        }
        boolean[][] p = bfs(arr,pac);
        boolean[][] a = bfs(arr,atl);

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(p[i][j] && a[i][j]) ans.add(List.of(i,j));
            }
        }
        return ans;
    }
}