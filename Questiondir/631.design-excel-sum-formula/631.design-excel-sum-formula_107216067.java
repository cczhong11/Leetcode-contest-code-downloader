public class Excel {
    int[][] val;
    boolean[][] used;
    HashMap<Long,String[]>summap;
    public Excel(int H, char W) {
        int i=H;
        int j=W+1-'A';
        val=new int[i][j];
        used=new boolean[i][j];
        summap=new HashMap<>();
    }

    public void set(int r, char c, int v) {
        long mark=(((long)r)<<20)+c;
        if(summap.containsKey(mark))summap.remove(mark);
        int i=r-1;
        int j=c-'A';
        val[i][j]=v;
        if(summap.size()>0){
            Iterator iter = summap.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                long key = (long) entry.getKey();
                String[] val = (String[]) entry.getValue();
                int row=(int)(key>>20);
                char col=(char)(key&0xFFFF);
                sum(row,col,val);
            }
        }
    }

    public int get(int r, char c) {
        int i=r-1;
        int j=c-'A';
        return val[i][j];
    }


    public int sum(int r, char c, String[] strs) {
        long mark=(((long)r)<<20)+c;
        summap.put(mark,strs);
        int sum=0;
        for(String i:strs){
            String[] rec=i.split(":");
            if(rec.length==1){
                char col=rec[0].charAt(0);
                int val=Integer.valueOf(rec[0].substring(1));
                sum+=get(val,col);
            }
            else{
                char col0=rec[0].charAt(0);
                int val0=Integer.valueOf(rec[0].substring(1));
                char col1=rec[1].charAt(0);
                int val1=Integer.valueOf(rec[1].substring(1));
                for(int row=val0;row<=val1;row++){
                    for(char col=col0;col<=col1;col++){
                        sum+=get(row,col);
                    }
                }
            }
        }
        int i=r-1;
        int j=c-'A';
        val[i][j]=sum;
        return sum;
    }

    public void setbool(int r, char c, boolean v) {
        int i=r-1;
        int j=c-'A';
        used[i][j]=v;
    }
    public boolean getbool(int r, char c) {
        int i=r-1;
        int j=c-'A';
        return used[i][j];
    }
}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(H, W);
 * obj.set(r,c,v);
 * int param_2 = obj.get(r,c);
 * int param_3 = obj.sum(r,c,strs);
 */