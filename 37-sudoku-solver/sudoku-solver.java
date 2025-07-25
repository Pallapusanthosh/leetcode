class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board){
        for(int i = 0; i<board.length;i++){
            for(int j = 0; j<board[0].length ; j++){
                if(board[i][j] == '.'){
                    for(char c = '1' ; c<='9';c++){
                        if(valid(board,c,i,j)){
                            board[i][j] = c;
                            if(solve(board) == true){
                                return true;
                            }
                            board[i][j] = '.';   
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean valid(char[][] board,char c,int row,int col){
        for(int i = 0;i<9;i++){
            if(board[row][i]== c){
                return false;
            }
            if(board[i][col] == c){
                return false;
            }
            if(board[3 * (row / 3) + i/3][3 * (col / 3)+ i%3]==c){
                return false;
            }
        }return true;
    }
}