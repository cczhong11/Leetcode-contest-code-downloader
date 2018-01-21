class Solution {
    public int[][] imageSmoother(int[][] M) {
        int m=M.length;
        if (m==0){
            return new int[0][0];
        }
        int n=M[0].length;
        int[][] newimg=new int[m][n];
        
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                int count=1;
                int agg=M[i][j];
                if (i>0){count++; agg+=M[i-1][j];}
                if (i<m-1){count++; agg+=M[i+1][j];}
                if (j>0){count++; agg+=M[i][j-1];}
                if (j<n-1){count++; agg+=M[i][j+1];}
                if (i>0 && j>0){count++; agg+=M[i-1][j-1];}
                if (i>0 && j<n-1){count++; agg+=M[i-1][j+1];}
                if (i<m-1 && j>0){count++; agg+=M[i+1][j-1];}
                if (i<m-1 && j<n-1){count++; agg+=M[i+1][j+1];}
                newimg[i][j]=agg/count;
            }
        }
        return newimg;
    }
}