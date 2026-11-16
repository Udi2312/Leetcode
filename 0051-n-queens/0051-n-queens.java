class Solution {
    List<List<String>> ans;
    public boolean isValid(List<String> board , int row, int col){
        for(int i = row-1; i>=0; i--){
            if(board.get(i).charAt(col) == 'Q') return false;
        }
        for(int i = row-1 , j = col-1; i>=0 && j>=0; i-- ,j--){
            if(board.get(i).charAt(j) == 'Q') return false;
        }
        for(int i = row-1 , j = col+1; i>=0 && j<board.size(); i--, j++){
            if(board.get(i).charAt(j) == 'Q') return false;
        }
        return true;
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
                board.set(row, sb.toString());
                solve(board, row + 1);
                sb.setCharAt(col, '.');
                board.set(row, sb.toString());
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        List<String> board = new ArrayList<>();
        // for(int i = 0; i<n; i++) board.add("");
        String s = "";
        for(int i = 0; i<n; i++) s = s + ".";
        for(int i = 0; i < n; i++) {
        board.add(s);
        }
        solve(board , 0);
        return ans;
    }
}