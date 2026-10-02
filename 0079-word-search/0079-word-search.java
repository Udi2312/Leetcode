class Solution {
    public boolean helper(char[][] board, String word, int i , int j, int k){
        if(k == word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if(board[i][j] != word.charAt(k)) return false;
        char c = board[i][j];
        board[i][j] = '.';
        boolean ans = helper(board , word, i+1, j, k+1) || helper(board , word, i-1, j, k+1) || helper(board , word, i, j+1, k+1) || helper(board , word, i, j-1, k+1);
        board[i][j] = c;
        return ans;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean flag = false;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == word.charAt(0)){
                    flag = helper(board , word, i , j , 0);
                    if(flag) return true;
                }
            }
        }
        return flag;
    }
}
