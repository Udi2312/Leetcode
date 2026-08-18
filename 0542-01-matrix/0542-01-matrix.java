class Solution {

    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int[][] ans = new int[m][n];

        Queue<Pair> q = new LinkedList<>();

        // Put all 0s into the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    q.add(new Pair(i, j));
                } 
                else {
                    ans[i][j] = -1;
                }
            }
        }

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!q.isEmpty()) {

            Pair p = q.remove();

            int r = p.i;
            int c = p.j;

            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < m &&
                    nc >= 0 && nc < n &&
                    ans[nr][nc] == -1) {

                    ans[nr][nc] = ans[r][c] + 1;

                    q.add(new Pair(nr, nc));
                }
            }
        }

        return ans;
    }
}