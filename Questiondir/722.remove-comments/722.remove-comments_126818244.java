class Solution {
    String delcom(String s)
    {
        int a=s.indexOf("//");
        int b=s.indexOf("/*");
        if (a<0 && b<0) return s;
        if (b<0 || (a>=0 && a<b)) return(s.substring(0,a));
        String now=s.substring(0,b);
        s=s.substring(b+2);
        int c=s.indexOf("*/");
        if (c<0) return now+"/*";
        s=s.substring(c+2);
        now=now+delcom(s);
        return now;
    }
    public List<String> removeComments(String[] source) {
        List<String> ans=new ArrayList<>();
        boolean flag=false;
        for (String s:source)
        {
            boolean bo=false;
            if (!flag && s.indexOf("/*")==0) bo=true;
            if (flag) s="/*"+s;
            String now=delcom(s);
            if (now.indexOf("/*")>=0)
            {
                now=now.substring(0,now.length()-2);
                flag=true;
                if (now.length()==0)
                {
                    if (bo) ans.add("/*"); else continue;
                }
                else ans.add(now);
            }
            else 
            {
                if (flag)
                {
                    String last=ans.get(ans.size()-1);
                    if (last.equals("/*")) ans.set(ans.size()-1,now); else ans.set(ans.size()-1,last+now);
                }
                else 
                    if (now.length()>0) ans.add(now);
                flag=false;
            }
        }
        
        List<String> ans2=new ArrayList<>();
        for (String s:ans) 
            if (s.length()>0) ans2.add(s);
        return ans2;
    }
}

