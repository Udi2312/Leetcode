class Solution {
    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public void solve(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        // Add all boundary land cells
        for (int i = 0; i < m; i++) {

            if (grid[i][0] == 'O') {
                // grid[i][0] = 0;
                q.add(new Pair(i, 0));
            }

            if (grid[i][n - 1] == 'O') {
                // grid[i][n - 1] = 0;
                q.add(new Pair(i, n - 1));
            }
        }

        for (int j = 0; j < n; j++) {

            if (grid[0][j] == 'O') {
                // grid[0][j] = 0;
                q.add(new Pair(0, j));
            }

            if (grid[m - 1][j] == 'O') {
                // grid[m - 1][j] = 0;
                q.add(new Pair(m - 1, j));
            }
        }
        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };
        boolean[][] vis = new boolean[m][n];
        while (!q.isEmpty()) {

            Pair p = q.remove();

            int r = p.i;
            int c = p.j;
            vis[r][c] = true;
            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < m &&
                    nc >= 0 && nc < n &&
                    grid[nr][nc] == 'O' && vis[nr][nc] == false) {
                        vis[nr][nc] = true;
                    // grid[nr][nc] = 'X';
                    q.add(new Pair(nr, nc));
                }
            }
        }
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 'O' && vis[i][j] == false) grid[i][j] = 'X'; 
            }
        }
    }
}