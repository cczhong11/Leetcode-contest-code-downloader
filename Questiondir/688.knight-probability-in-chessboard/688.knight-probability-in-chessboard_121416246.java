class Solution {
    int[] dx = {1,2,2,1,-1,-2,-2,-1};
    int[] dy = {2,1,-1,-2,-2,-1,1,2};
    public double knightProbability(int N, int K, int r, int c) {
        if (K==0) return 1;
        if (N<3) return 0;
        if (N==3 && r==1 && c==1) return 0;
        double[][][] p = new double[N][N][K+1];
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                p[i][j][0] = 1;
            }
        }
        helper (N,K,r,c,p);
        return p[r][c][K];
    }
    double helper(int n, int k, int r, int c, double[][][]p) {
        if (p[r][c][k]>0.0000000000001) return p[r][c][k];
        for (int s=0;s<8;s++){
            int i = r+dx[s];
            int j = c+dy[s];
            if (i<0||i>=n||j<0||j>=n) continue;
            p[r][c][k] += helper(n,k-1,i,j,p)/8;
        }
        return p[r][c][k]; 
    }
}