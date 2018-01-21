class Solution {
    public int[][] candyCrush(int[][] board) {
        boolean cont=true;
        while(cont){
            cont=removeElement(board);
        }
        return board;
    }
    public boolean removeElement(int[][] board){
        boolean res=false;
        boolean[][] toRemove=new boolean[board.length][board[0].length];
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                if(board[r][c]!=0&&r+2<board.length&&board[r][c]==board[r+1][c]&&board[r][c]==board[r+2][c]){
                    res=true;
                    toRemove[r][c]=true;
                    toRemove[r+1][c]=true;
                    toRemove[r+2][c]=true;
                }
                if(board[r][c]!=0&&c+2<board[0].length&&board[r][c]==board[r][c+1]&&board[r][c]==board[r][c+2]){
                    res=true;
                    toRemove[r][c]=true;
                    toRemove[r][c+1]=true;
                    toRemove[r][c+2]=true;
                }
            }
        }
        if(res){
            for(int r=0;r<board.length;r++){
                for(int c=0;c<board[0].length;c++){
                    if(toRemove[r][c]){
                        board[r][c]=0;
                    }
                }
            }
            dropElement(board);
        }
        return res;
    }
    public void dropElement(int[][] board){
        for(int c=0;c<board[0].length;c++){
            int currR=board.length-1;
            for(int r=board.length-1;r>=0;r--){
                if(board[r][c]!=0){
                    board[currR][c]=board[r][c];
                    currR--;
                }
            }
            while(currR>=0){
                board[currR][c]=0;
                currR--;
            }
        }
    }
}