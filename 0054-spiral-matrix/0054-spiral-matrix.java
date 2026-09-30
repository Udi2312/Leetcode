class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int tr = 0;
        int br = n-1;
        int lc = 0;
        int rc = m-1;
        while(tr <= br && lc <= rc){
            for(int i = lc; i<=rc; i++){
                l.add(matrix[tr][i]);
            }
            tr++;
            if(tr <= br && lc <= rc){
            for(int i = tr; i<=br; i++){
                l.add(matrix[i][rc]);
            }
            rc--;
            }
            if(tr <= br && lc <= rc){
            for(int i = rc; i>=lc; i--){
                l.add(matrix[br][i]);
            }
            br--;
            }
            if(tr <= br && lc <= rc){
            for(int i = br; i>=tr; i--){
                l.add(matrix[i][lc]);
            }
            lc++;
            }
        }
        return l;
    }
}