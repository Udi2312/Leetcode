class Solution {

    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        int fresh = 0;

        // Add ALL initially rotten oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int minutes = 0;

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!q.isEmpty() && fresh > 0) {

            int size = q.size();

            // One complete BFS level = one minute
            for (int k = 0; k < size; k++) {

                Pair current = q.remove();

                int r = current.i;
                int c = current.j;

                for (int[] dir : directions) {

                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nr < m &&
                        nc >= 0 && nc < n &&
                        grid[nr][nc] == 1) {

                        grid[nr][nc] = 2;
                        fresh--;

                        q.add(new Pair(nr, nc));
                    }
                }
            }

            minutes++;
        }

        // Fresh oranges still remain
        if (fresh > 0) {
            return -1;
        }

        return minutes;
    }
}