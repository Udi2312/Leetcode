class Solution {
    class Trip implements Comparable<Trip>{
        int r;
        int c;
        int cost;
        Trip(int r, int c, int cost){
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
        public int compareTo(Trip t){
            if(this.cost == t.cost) return this.r - t.r;
            return this.cost - t.cost;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0]==1 || grid[m-1][n-1]==1){
            return -1;
        }
        int ans[][] = new int[m][n];
        for(int arr[] : ans) Arrays.fill(arr , Integer.MAX_VALUE);
        ans[0][0] = 1;
        PriorityQueue<Trip> pq = new PriorityQueue<Trip>();
        pq.add(new Trip(0 , 0, 1));
        while(pq.size() > 0){
            Trip front = pq.remove();
            int row = front.r;
            int col = front.c;
            int cost = front.cost;
            if(row > 0 && grid[row-1][col] == 0){
                int tc = cost + 1;
                if(tc < ans[row-1][col]){
                    ans[row-1][col] = tc;
                    pq.add(new Trip(row-1, col , tc));
                }
            }
            if(col > 0 && grid[row][col-1] == 0){
                int tc = cost + 1;
                if(tc < ans[row][col-1]){
                    ans[row][col-1] = tc;
                    pq.add(new Trip(row, col-1 , tc));
                }
            }
            if(row < m-1 && grid[row+1][col] == 0){
                int tc = cost + 1;
                if(tc < ans[row+1][col]){
                    ans[row+1][col] = tc;
                    pq.add(new Trip(row+1, col , tc));
                }
            }
            if(col < n-1 && grid[row][col+1] == 0){
                int tc = cost + 1;
                if(tc < ans[row][col+1]){
                    ans[row][col+1] = tc;
                    pq.add(new Trip(row, col+1 , tc));
                }
            }
            if(row > 0 && col > 0 && grid[row-1][col-1] == 0){
                int tc = cost + 1;
                if(tc < ans[row-1][col-1]){
                    ans[row-1][col-1] = tc;
                    pq.add(new Trip(row-1, col-1 , tc));
                }
            }
            if(row > 0 && col < n-1 && grid[row-1][col+1] == 0){
                int tc = cost + 1;
                if(tc < ans[row-1][col+1]){
                    ans[row-1][col+1] = tc;
                    pq.add(new Trip(row-1, col+1 , tc));
                }
            }
            if(row < m-1 && col > 0 && grid[row+1][col-1] == 0){
                int tc = cost + 1;
                if(tc < ans[row+1][col-1]){
                    ans[row+1][col-1] = tc;
                    pq.add(new Trip(row+1, col-1 , tc));
                }
            }
            if(row < m-1 && col < n-1 && grid[row+1][col+1] == 0){
                int tc = cost + 1;
                if(tc < ans[row+1][col+1]){
                    ans[row+1][col+1] = tc;
                    pq.add(new Trip(row+1, col+1 , tc));
                }
            }
        }
        if(ans[m-1][n-1] == Integer.MAX_VALUE) return -1;
        return ans[m-1][n-1];
    }
}