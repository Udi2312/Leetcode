class Solution {
    class Trip implements Comparable<Trip>{
        int row;
        int col;
        int effort;
        Trip(int row, int col, int effort){
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
        public int compareTo(Trip t){
            if(this.effort == t.effort) return this.row-t.row;
            return this.effort -  t.effort;
        }
    }
    public int minimumEffortPath(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int [][] ans = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                ans[i][j] = Integer.MAX_VALUE;
            }
        }
        ans[0][0] = 0;
        PriorityQueue<Trip> pq = new PriorityQueue<>();
        pq.add(new Trip(0,0,0));
        while(pq.size() > 0){
            Trip front = pq.remove();
            int row = front.row;
            int col = front.col;
            int effort = front.effort;
            if(row==m-1 && col==n-1) break;
            if(row > 0){
                int e = Math.abs(arr[row][col] - arr[row-1][col]);
                e = Math.max(e,effort);
                if(e < ans[row-1][col]){
                    ans[row-1][col] = e;
                    pq.add(new Trip(row-1,col,e));
                }
            }
            if(col > 0){
                int e = Math.abs(arr[row][col] - arr[row][col-1]);
                e = Math.max(e,effort);
                if(e < ans[row][col-1]){
                    ans[row][col-1] = e;
                    pq.add(new Trip(row,col-1,e));
                }
            }
            if(row < m-1){
                int e = Math.abs(arr[row][col] - arr[row+1][col]);
                e = Math.max(e,effort);
                if(e < ans[row+1][col]){
                    ans[row+1][col] = e;
                    pq.add(new Trip(row+1,col,e));
                }
            }
            if(col < n-1){
                int e = Math.abs(arr[row][col] - arr[row][col+1]);
                e = Math.max(e,effort);
                if(e < ans[row][col+1]){
                    ans[row][col+1] = e;
                    pq.add(new Trip(row,col+1,e));
                }
            }

        }
        return ans[m-1][n-1];
    }
}