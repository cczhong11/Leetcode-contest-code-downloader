class Solution {
    public int[][] candyCrush(int[][] board) {
        int n=board.length,m=board[0].length;
        boolean[][] bo=new boolean [n][m];
        boolean changed=true;
        while (changed)
        {
            changed=false;
            for (int i=0;i<n;i++)
                for (int j=0;j<m;j++)
                    bo[i][j]=false;
            for (int i=0;i<n;i++)
                for (int j=0;j<m;j++)
                if (board[i][j]!=0)
                {
                    if (i<n-2)
                    {
                        if (board[i][j]==board[i+1][j] && board[i][j]==board[i+2][j])
                        {
                            int ii=i+2;
                            while (ii<n-1 && board[ii+1][j]==board[i][j]) ii++;
                            for (int k=i;k<=ii;k++) bo[k][j]=true;
                        }
                    }
                    if (j<m-2)
                    {
                        if (board[i][j]==board[i][j+1] && board[i][j]==board[i][j+2])
                        {
                            int jj=j+2;
                            while (jj<m-1 && board[i][jj+1]==board[i][j]) jj++;
                            for (int k=j;k<=jj;k++) bo[i][k]=true;
                        }
                    }
                }
            for (int i=0;i<n;i++)
                for (int j=0;j<m;j++)
                    if (bo[i][j]) 
                    {
                        changed=true;
                        board[i][j]=0;
                    }
            int[][] temp=new int[n][m];
            for (int i=0;i<n;i++)
                for (int j=0;j<m;j++)
                    temp[i][j]=0;
            for (int j=0;j<m;j++)
            {
                int ii=n-1;
                for (int i=n-1;i>=0;i--)
                    if (board[i][j]!=0)
                    {
                        temp[ii][j]=board[i][j];
                        ii--;
                    }
            }
            for (int i=0;i<n;i++)
                for (int j=0;j<m;j++)
                    board[i][j]=temp[i][j];
        }
        return board;
    }
}