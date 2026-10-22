class Solution {
    static int parent[];
    static int size[];

    public void union(int a , int b){
        int leaderA = find(a);
        int leaderB = find(b);
        if(leaderA != leaderB){
        if(size[leaderA] > size[leaderB]){
            parent[leaderB] = leaderA;
            size[leaderA] += size[leaderB];
        }
        else{
            parent[leaderA] = leaderB;
            size[leaderB] += size[leaderA];
        }
        }
    }

    public int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
    public int findCircleNum(int[][] arr) {
        int n = arr.length;
        parent = new int[n+1];
        size = new int[n+1];
        for(int i = 1; i<=n; i++){
            parent[i] = i;
            size[i] = 1;
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i != j && arr[i][j] == 1) union(i+1,j+1);
            }
        }
        int ans = 0;
        for(int i = 1; i<=n; i++){
            if(parent[i] == i) ans++;
        }
        return ans;
    }
}