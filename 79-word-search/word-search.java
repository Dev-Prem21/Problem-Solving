class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(helper(board,word,i,j,0)) return true;
            }
        }
       return false; 
    }
    public boolean helper(char[][] board,String p,int row,int col,int index){
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) 
            return false;
        if(board[row][col]!=p.charAt(index)) return false;
        if(index==p.length()-1){
            return true;
        }
        char temp = board[row][col];
        board[row][col] = '#';
         boolean found = helper(board,p, row-1, col, index+1) ||
                        helper(board,p, row+1, col, index+1) ||
                        helper(board, p, row, col-1, index+1) ||
                        helper(board, p, row, col+1, index+1);
        board[row][col] = temp;
        return found;

    }
}