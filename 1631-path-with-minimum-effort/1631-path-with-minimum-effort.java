class Solution {
    class Trip implements Comparable<Trip>{
        int r;
        int c;
        int cost;
        Trip(int r , int c, int cost){
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
        public int compareTo(Trip t){
            if(this.cost - t.cost == 0) return this.r - t.r;
            return this.cost - t.cost;
         }
    }
    public int minimumEffortPath(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;
        int eff[][] = new int[r][c];
        for(int a[] : eff) Arrays.fill(a , Integer.MAX_VALUE);
        eff[0][0] = 0;
        PriorityQueue<Trip> pq = new PriorityQueue<Trip>();
        pq.add(new Trip(0 , 0, 0));
        while(pq.size() > 0){
            Trip front = pq.remove();
            int row = front.r;
            int col = front.c;
            int cost = front.cost;
            if(row == r-1 && col == c-1) break;
            if(row > 0){
                int e = Math.abs(arr[row][col] - arr[row-1][col]);
                e = Math.max(e , cost);
                if(eff[row-1][col] > e){
                    eff[row-1][col] = e;
                    pq.add(new Trip(row-1, col , e));
                }
            }
            if(col > 0){
                int e = Math.abs(arr[row][col] - arr[row][col-1]);
                e = Math.max(e , cost);
                if(eff[row][col-1] > e){
                    eff[row][col-1] = e;
                    pq.add(new Trip(row, col-1 , e));
                }
            }
            if(row < r-1){
                int e = Math.abs(arr[row][col] - arr[row+1][col]);
                e = Math.max(e , cost);
                if(eff[row+1][col] > e){
                    eff[row+1][col] = e;
                    pq.add(new Trip(row+1, col , e));
                }
            }
            if(col < c-1){
                int e = Math.abs(arr[row][col] - arr[row][col+1]);
                e = Math.max(e , cost);
                if(eff[row][col+1] > e){
                    eff[row][col+1] = e;
                    pq.add(new Trip(row, col+1 , e));
                }
            }
        }
        return eff[r-1][c-1];
    }
}