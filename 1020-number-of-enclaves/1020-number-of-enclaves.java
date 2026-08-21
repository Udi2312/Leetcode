class Solution {

    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int numEnclaves(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        // Add all boundary land cells
        for (int i = 0; i < m; i++) {

            if (grid[i][0] == 1) {
                grid[i][0] = 0;
                q.add(new Pair(i, 0));
            }

            if (grid[i][n - 1] == 1) {
                grid[i][n - 1] = 0;
                q.add(new Pair(i, n - 1));
            }
        }

        for (int j = 0; j < n; j++) {

            if (grid[0][j] == 1) {
                grid[0][j] = 0;
                q.add(new Pair(0, j));
            }

            if (grid[m - 1][j] == 1) {
                grid[m - 1][j] = 0;
                q.add(new Pair(m - 1, j));
            }
        }

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        // Remove all land connected to the boundary
        while (!q.isEmpty()) {

            Pair p = q.remove();

            int r = p.i;
            int c = p.j;

            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < m &&
                    nc >= 0 && nc < n &&
                    grid[nr][nc] == 1) {

                    grid[nr][nc] = 0;
                    q.add(new Pair(nr, nc));
                }
            }
        }

        // Remaining land cells are enclaves
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }
}