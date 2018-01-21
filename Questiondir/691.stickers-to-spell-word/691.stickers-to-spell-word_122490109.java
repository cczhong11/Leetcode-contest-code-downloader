class Solution {
    int[] mapp=new int[150];
    int[][] st;
    int n,m=0;
    String s="";
    Map<Long,Integer> map=new HashMap<>();
    int[] turn(String ta)
    {
        int len=s.length();
        int l=ta.length();
        int[] a=new int[len];
        for (int i=0;i<l;i++)
            if (mapp[ta.charAt(i)]!=-1)
            {
                int index=mapp[ta.charAt(i)];
                a[index]++;
            }
        return a;
    }
    long hash(int[] a)
    {       
        long ans=0;
        for (int i=0;i<m;i++)
            ans=ans*16+Math.max(a[i],0);
        return ans;
    }
    int dfs(int[] a)
    {
        long x=hash(a);
        if (map.containsKey(x)) return map.get(x);
        int ans=1000000000;
        for (int i=0;i<n;i++)
        {
            int[] b=new int[m];
            for (int j=0;j<m;j++) b[j]=a[j]-st[i][j];
            long y=hash(b);
            if (x==y) continue;
            ans=Math.min(dfs(b)+1,ans);
        }
        map.put(x,ans);
        return ans;
    }
    public int minStickers(String[] stickers, String target) {
        n=stickers.length;
        int l=target.length();
        boolean[] bo=new boolean[150];
        for (int i=0;i<150;i++) mapp[i]=-1;
        for (int i=0;i<l;i++)
        {
            char ch=target.charAt(i);
            if (!bo[ch]) 
            {
                s=s+ch;
                mapp[ch]=m;
                m++;
            }
            bo[ch]=true;
        }
        int[] a=turn(target);
        st=new int[n][m];
        for (int i=0;i<n;i++) st[i]=turn(stickers[i]);
        for (int i=0;i<m;i++)
        {
            boolean boo=false;
            for (int j=0;j<n;j++)
            {
                if (st[j][i]>0) boo=true;
            }
            if (!boo) return -1;
        } 
        //a=st[2];
        //if (1==1) return a[0]+a[1]*10+a[2]*100+a[3]*1000;
        long zero=0;
        map.put(zero,0);
        int[] b=new int[m];
        return dfs(a);
    }
}