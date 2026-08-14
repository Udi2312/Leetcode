class Solution {
    public int findTheCity(int n, int[][] edges, int threshold) {
        int[][] dist = new int[n][n];
        for(int  i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            dist[u][v] = wt;
            dist[v][u] = wt;
            // dist[i][i] = 0;
        }

        for(int k = 0; k<n; k++){
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if(i==k || j==k) continue;
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE)
                    dist[i][j] = Math.min(dist[i][j] , dist[i][k] + dist[k][j]);
                }
            }
        }
        int minCity = -1;
        int minCount = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            int count = 0;
            for(int j = 0; j<n; j++){
            if(i==j) continue;
                if(dist[i][j] <= threshold) count++;
            }
            if(count <= minCount){
                minCount = count;
                minCity = i;
            }
        }
        return minCity;
    }
}