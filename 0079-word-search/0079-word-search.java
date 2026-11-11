class Solution {
    boolean flag;
    public boolean helper(char[][] board, int i, int j, String word, int k){
        if(k >= word.length()){
            return true;
        }
        if(i >= board.length || j >= board[0].length || i<0 || j<0) return false;
        if(board[i][j] != word.charAt(k)) return false;
        char ch = board[i][j];
        board[i][j] = '*';
        boolean found = helper(board , i+1, j, word, k+1) || helper(board , i-1, j , word , k+1) || helper(board , i, j+1, word , k+1) || helper(board , i , j-1, word , k+1);
        board[i][j] = ch;
        return found;
    }
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(helper(board , i,j , word , 0)) return true;
            }
        }
        return false;
    }
}