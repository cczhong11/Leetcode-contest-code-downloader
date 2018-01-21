public class Solution {
    List<Integer> a,c;
    List<List<Integer>> b;
    int n,m;
    Map<Integer,Integer> map=new HashMap<>();
    int hashc(List<Integer> a)
    {
        int num=0;
        for (int i=0;i<a.size();i++) num=num*10+Math.max(a.get(i),0);
        return num;
    }
    int dfs(List<Integer> c)
    {
        for (int i=0;i<n;i++)
            if (c.get(i)<0) return 10000000;
        int ha=hashc(c);
        if (map.containsKey(ha)) return map.get(ha);
        int ans=0;
        for (int i=0;i<n;i++) ans+=Math.max(c.get(i),0)*a.get(i);
        map.put(ha,ans);
        for (int i=0;i<m;i++)
        {
            List<Integer> now=b.get(i);
            int price=now.get(n);
            for (int j=0;j<n;j++) c.set(j,c.get(j)-now.get(j));
            ans=Math.min(ans,price+dfs(c));
            for (int j=0;j<n;j++) c.set(j,c.get(j)+now.get(j));
        }
        map.put(ha,ans);
        return ans;
    }
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        a=price;
        b=special;
        n=price.size();
        m=special.size();
        return dfs(needs);
    }
}