class Solution {
    List<List<String>> ans;
    HashSet<Integer> colu;
    HashSet<Integer> adia;
    HashSet<Integer> dia;
    public boolean isValid(List<String> board , int row, int col){
        if(colu.contains(col) || dia.contains(row+col) || adia.contains(row-col)) return false;
        else return true;
    }
    public void solve(List<String> board , int row){
        if(row >= board.size()){
            ans.add(new ArrayList<>(board));
            return;
        }
        for(int col = 0; col<board.size(); col++){
            if(isValid(board , row, col)){
                StringBuilder sb = new StringBuilder(board.get(row));
                sb.setCharAt(col, 'Q');
                colu.add(col);
                dia.add(row+col);
                adia.add(row-col);
                board.set(row, sb.toString());

                solve(board, row + 1);

                colu.remove(col);
                dia.remove(row+col);
                adia.remove(row-col);
                sb.setCharAt(col, '.');
                board.set(row, sb.toString());
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        colu = new HashSet<>();
        dia = new HashSet<>();
        adia = new HashSet<>();
        List<String> board = new ArrayList<>();
        String s = "";
        for(int i = 0; i<n; i++) s = s + ".";
        for(int i = 0; i < n; i++) {
        board.add(s);
        }
        solve(board , 0);
        return ans;
    }
}