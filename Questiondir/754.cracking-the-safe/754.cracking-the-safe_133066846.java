class Solution {
    HashSet<String> allp=new HashSet<String>();
    public String crackSafe(int n, int k) {
        generate(allp,n,k,"");
        String u="";
        for (int i=0;i<n;i++)
            u=u+"0";
        int direction=0;
        while (allp.size()>0)
        {
            //System.out.println(u);
            
            String w=u;
            String sufx=w.substring(w.length()-n,w.length());
            if (direction==0)
            {
                if (!allp.contains(sufx))
                {
                    //System.out.println(Integer.parseInt(u.charAt(u.length()-1));
                    if ((k-((int)(u.charAt(u.length()-1))-'0'))>1)
                    {
                        int x=(int)(u.charAt(u.length()-1))-'0';
                        
                        u=u.substring(0,u.length()-1)+(x+1);
                        direction=0;
                    }
                    else
                    {
                        u=u.substring(0,u.length()-1);
                        direction=-1;
                    }
                }
                else
                {
                    allp.remove(sufx);
                    u=u+"0";
                    direction=0;
                }
            }
            else
            {
                allp.add(sufx);
                if ((k-((int)(u.charAt(u.length()-1))-'0'))>1)
                    {
                        int x=(int)(u.charAt(u.length()-1))-'0';
                        u=u.substring(0,u.length()-1)+(x+1);
                        direction=0;
                }
                else
                {
                        u=u.substring(0,u.length()-1);
                        direction=-1;
                }
            }

        }
        return u.substring(0,u.length()-1);
    }
    private void generate(HashSet<String> p,int n, int k, String w)
    {
        if (w.length()==n)
            p.add(w);
        else
        {
            for (int i=0;i<k;i++)
            {
                generate(p,n,k,w+i);
            }
        }
    }
    private String crack(String w,int n, int k)
    {
        if (allp.size()==0)
        {
            return w;
        }

        if (w.length()<(n-1))
        {
            for (int i=0;i<k;i++)
            {
                String v=crack(w+i,n,k);
                if (!v.equals(""))
                    return v;
            }
        }
        else
        {
            String sufx=w.substring(w.length()-n+1,w.length());
            for (int i=0;i<k;i++)
            {
                String gv=sufx+i;
                if (allp.contains(gv))
                {
                    allp.remove(gv);
                    String v=crack(w+i,n,k);
                    if (!v.equals(""))
                        return v;
                    allp.add(gv);
                }
            }
        }
        return "";
    }
}