class Solution {
    public boolean check(char[][]board,int i,int j,char a){
        int n=board.length;
        int m=board[0].length;
        for(int k=0;k<m;k++){
            if(k!=j&&board[i][k]==a){
                return false;
            }
        }
        for(int k=0;k<n;k++){
            if(k!=i&&board[k][j]==a){
                return false;
            }
        }
        int row=(i/3)*3;
        int col=(j/3)*3;
        for(int r=row;r<row+3;r++){
            for(int c=col;c<col+3;c++){
                if((r!=i||c!=j)&&board[r][c]==a){
                    return false;
                }
            }
        }
        return true;

    }
    public boolean isValidSudoku(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]!='.'){
                    if(!check(board,i,j,board[i][j])){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
