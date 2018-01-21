class Solution {
    Map<String,String> map=new HashMap<>();
    boolean bo=false;
    void dfs(String s,String next,int x)
    {
        if (s.length()==1) bo=true;
        if (bo) return;
        if (x==s.length()-1) dfs(next,"",0); 
        else
        {
            String p=map.getOrDefault(s.substring(x,x+2),"");
            for (int i=0;i<p.length();i++)
            {
                char ch=p.charAt(i);
                dfs(s,next+ch,x+1);
                if (bo) return;
            }
        }
    }
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String s:allowed)
        {
            String ss=s.substring(0,2);
            char ch=s.charAt(2);
            map.put(ss,map.getOrDefault(ss,"")+ch);
        }
        dfs(bottom,"",0);
        return bo;
    }
}