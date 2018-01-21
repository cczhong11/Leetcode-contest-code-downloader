class Solution {
    int wallcount;
    public int containVirus(int[][] grid) {
        int[] wall=new int[101*100*3];
        wallcount=0;
        while (true)
        {
        //TODO check areas
        int[] root=new int[101*100];
        for (int i=0;i<grid.length;i++)
            for (int j=0;j<grid[0].length;j++)
            {
                int neighbors=0;
                int l=0;
                int u=0;
                if ((i>0)&&(grid[i][j]==1)&&(grid[i-1][j]==1)&&(checkwall(i,j,0,wall)==false))
                {
                    l=1;
                }
                if ((j>0)&&(grid[i][j]==1)&&(grid[i][j-1]==1)&&(checkwall(i,j,1,wall)==false))
                {
                    u=1;
                }
                if ((l+u)==2)
                {
                    int c=encode(i,j);
                    int rootl=findroot(i-1,j,root);
                    int rootr=findroot(i,j-1,root);
                    root[rootl]=c;
                    root[rootr]=c;
                    root[c]=c;
                }
                else if (l==1)
                {
                    int c=encode(i,j);
                    root[c]=findroot(i-1,j,root);
                }
                else if (u==1)
                {
                    int c=encode(i,j);
                    root[c]=findroot(i,j-1,root);
                }
                else if (grid[i][j]==1)
                {
                    int c=encode(i,j);
                    root[c]=c;
                }
            }
        //TODO check danger area
        int maxroot=0;
        int maxinf=0;
        HashMap<Integer, Integer> hm=new HashMap<Integer, Integer>();
        for (int i=0;i<grid.length;i++)
        {
            String s="";
            for (int j=0;j<grid[0].length;j++)
            {
                
                HashSet<Integer> see=new HashSet<Integer>();
                if ((i>0)&&(grid[i][j]==0)&&(grid[i-1][j]==1)&&(checkwall(i,j,0,wall)==false))
                {
                    see.add(findroot(i-1,j,root));

                }
                if ((j>0)&&(grid[i][j]==0)&&(grid[i][j-1]==1)&&(checkwall(i,j,1,wall)==false))
                {
                    see.add(findroot(i,j-1,root));
                }
                if ((i<grid.length-1)&&(grid[i][j]==0)&&(grid[i+1][j]==1)&&(checkwall(i+1,j,0,wall)==false))
                {
                    see.add(findroot(i+1,j,root));

                }
                if ((j<grid[0].length-1)&&(grid[i][j]==0)&&(grid[i][j+1]==1)&&(checkwall(i,j+1,1,wall)==false))
                {
                    see.add(findroot(i,j+1,root));
                }
                for (Integer lw:see)
                {
                    int l=add1(hm,lw);
                    if (l>maxinf)
                    {
                        maxinf=l;
                        maxroot=lw;
                    }
                }   
                s=s+" "+findroot(i,j,root);
            }
             
            //System.out.println(s);
        }
        if (maxinf==0)
        {
            return wallcount;
        }
        //TODO build wall area
        for (int i=0;i<grid.length;i++)
        {
            for (int j=0;j<grid[0].length;j++)
            {
                //HashSet<Integer> see=new HashSet<Integer>();
                if ((i>0)&&(grid[i][j]==0)&&(findroot(i-1,j,root)==maxroot)&&(checkwall(i,j,0,wall)==false))
                {
                    buildwall(i,j,0,wall);
                }
                if ((j>0)&&(grid[i][j]==0)&&(findroot(i,j-1,root)==maxroot)&&(checkwall(i,j,1,wall)==false))
                {
                    buildwall(i,j,1,wall);
                }
                if ((i<grid.length-1)&&(grid[i][j]==0)&&(findroot(i+1,j,root)==maxroot)&&(checkwall(i+1,j,0,wall)==false))
                {
                    buildwall(i+1,j,0,wall);

                }
                if ((j<grid[0].length-1)&&(grid[i][j]==0)&&(findroot(i,j+1,root)==maxroot)&&(checkwall(i,j+1,1,wall)==false))
                {
                    buildwall(i,j+1,1,wall);
                }
            }
        }
        //TODO infect
        int[][] newgrid=new int[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++)
        {
            String s="";
            for (int j=0;j<grid[0].length;j++)
            {
                //HashSet<Integer> see=new HashSet<Integer>();
                newgrid[i][j]=grid[i][j];
                if ((i>0)&&(grid[i][j]==0)&&(grid[i-1][j]==1)&&(checkwall(i,j,0,wall)==false))
                {
                    newgrid[i][j]=1;

                }
                if ((j>0)&&(grid[i][j]==0)&&(grid[i][j-1]==1)&&(checkwall(i,j,1,wall)==false))
                {
                    newgrid[i][j]=1;
                }
                if ((i<grid.length-1)&&(grid[i][j]==0)&&(grid[i+1][j]==1)&&(checkwall(i+1,j,0,wall)==false))
                {
                   newgrid[i][j]=1;

                }
                if ((j<grid[0].length-1)&&(grid[i][j]==0)&&(grid[i][j+1]==1)&&(checkwall(i,j+1,1,wall)==false))
                {
                    newgrid[i][j]=1;
                } 
                s=s+" "+findroot(i,j,root);
            }
           //System.out.println(s);
        }
            grid=newgrid;
            //System.out.println(wallcount);
        }
        //return wallcount;
    }
    private int add1(HashMap<Integer, Integer> hm, int k)
    {
        hm.putIfAbsent(k,0);
        int u=hm.get(k)+1;
        hm.put(k,u);
        return u;
    }
    private int findroot(int x, int y, int[] root){
        int z=encode(x,y);
        return findrootz(z,root);
    }
    private int findrootz(int z, int[] root){
        if (root[z]==z)
            return z;
        else
        {
            int w=findrootz(root[z],root);
            root[z]=w;
            return w;
        }
    }
    private int encode(int x, int y){
        //System.out.println(x*100+y);
        return x*100+y+1;
    }
    private int decodex(int z){
        return (z-1)/100;
    }
    private int decodey(int z){
        return (z-1)%100;
    }
    private boolean checkwall(int x, int y, int d, int[] wall)
    {
        if (wall[x*100+y+10100*d]==0)
            return false;
        else
            return true;
    }
    private void buildwall(int x, int y, int d, int[] wall)
    {
        wall[x*100+y+10100*d]=1;
        wallcount++;
    }
}