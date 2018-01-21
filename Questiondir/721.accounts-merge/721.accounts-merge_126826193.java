class Solution {
    int[] fa;
    int find(int x)
    {
        if (fa[x]!=x) fa[x]=find(fa[x]);
        return fa[x];
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        fa=new int[n];
        for (int i=0;i<n;i++) fa[i]=i;
        Map<String,Integer> map=new HashMap<>();
        for (int i=0;i<n;i++)
        {
            List<String> list=accounts.get(i);
            int m=list.size();
            for (int j=1;j<m;j++)
            {
                String s=list.get(j);
                int x=map.getOrDefault(s,-1);
                if (x==-1) map.put(s,i);
                else
                {
                    int a=find(x),b=find(i);
                    fa[b]=a;
                }
            }
        }
        List<List<String>> ans=new ArrayList<>();
        List<List<String>> email=new ArrayList<>();
        for (int i=0;i<n;i++) email.add(new ArrayList<>());
        for (String s:map.keySet())
        {
            int x=find(map.get(s));
            email.get(x).add(s);
        }
        for (int i=0;i<n;i++) 
        {
            if (email.get(i).size()==0) continue;
            Collections.sort(email.get(i));
            List<String> list=new ArrayList<>();
            list.add(accounts.get(i).get(0));
            for (String s:email.get(i)) list.add(s);
            ans.add(list);
        }
        return ans;
    }
}