public class Excel {
    private int[][] val;
    private int[][] bo;
    private String[][][] ss;
    public Excel(int H, char W) {
        val=new int[H+1][W-'A'+1];
        bo=new int[H+1][W-'A'+1];
        ss=new String[H+1][W-'A'+1][];
        for (int i=1;i<=H;i++)
            for (int j=0;j<W-'A'+1;j++)
            {
                val[i][j]=0;
                bo[i][j]=-1;
            }
    }
    
    public void set(int r, char c, int v) {
        val[r][c-'A']=v;
        bo[r][c-'A']=-1;
    }
    
    public int get(int r, char c) {
        if (bo[r][c-'A']==-1) return val[r][c-'A'];
        int ans=0;
        for (String s:ss[r][c-'A'])
        {
            int mh=s.indexOf(':');
            if (mh<0)
            {
                char cc=s.charAt(0);
                int rr=s.charAt(1)-48;
                if (s.length()==3) rr=rr*10+s.charAt(2)-48;
                ans+=get(rr,cc);
            }
            else
            {
                String[] aa= s.split(":");
                char cc1=aa[0].charAt(0);
                int rr1=aa[0].charAt(1)-48;
                if (aa[0].length()==3) rr1=rr1*10+aa[0].charAt(2)-48;
                char cc2=aa[1].charAt(0);
                int rr2=aa[1].charAt(1)-48;
                if (aa[1].length()==3) rr2=rr2*10+aa[1].charAt(2)-48;
                for (int i=rr1;i<=rr2;i++)
                    for (char j=cc1;j<=cc2;j++)
                    ans+=get(i,j);
            }
        }
        return ans;
    }
    
    public int sum(int r, char c, String[] strs) {
        bo[r][c-'A']=strs.length;
        ss[r][c-'A']=strs;
        return get(r,c);
    }
}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(H, W);
 * obj.set(r,c,v);
 * int param_2 = obj.get(r,c);
 * int param_3 = obj.sum(r,c,strs);
 */