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
            if(this.cost == t.cost) return Integer.compare(this.r , t.r);
            return Integer.compare(this.cost , t.cost);
        }
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans[][] = new int[n][m];
        for(int arr[] : ans) Arrays.fill(arr , Integer.MAX_VALUE);
        ans[0][0] = grid[0][0];
        PriorityQueue<Trip> q = new PriorityQueue<Trip>();
        q.add(new Trip(0 , 0 , grid[0][0]));
        while(q.size() > 0){
            Trip front = q.remove();
            int row = front.r;
            int col = front.c;
            int cost = front.cost;
            if(row > 0){
                int tc = Math.max(cost , grid[row-1][col]);
                if(tc < ans[row-1][col]){
                    ans[row-1][col] = tc;
                    q.add(new Trip(row-1,col,tc));
                }
            }
            if(col > 0){
                int tc = Math.max(cost , grid[row][col-1]);
                if(tc < ans[row][col-1]){
                    ans[row][col-1] = tc;
                    q.add(new Trip(row,col-1,tc));
                }
            }
            if(row < n-1){
                int tc = Math.max(cost , grid[row+1][col]);
                if(tc < ans[row+1][col]){
                    ans[row+1][col] = tc;
                    q.add(new Trip(row+1,col,tc));
                }
            }
            if(col < m-1){
                int tc = Math.max(cost , grid[row][col+1]);
                if(tc < ans[row][col+1]){
                    ans[row][col+1] = tc;
                    q.add(new Trip(row,col+1,tc));
                }
            }
        }
        return ans[n-1][m-1];
    }
}