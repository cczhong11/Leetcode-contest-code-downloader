class Solution {
    HashSet<Integer> dset=new HashSet<Integer>();
    HashMap<Integer,Integer> v1=new HashMap<Integer,Integer>();
    HashMap<Integer,Integer> v2=new HashMap<Integer,Integer>();
    public int openLock(String[] deadends, String target) {
        dset=new HashSet<Integer>();
        v1=new HashMap<Integer,Integer>();
        v2=new HashMap<Integer,Integer>();
        for (int i=0;i<deadends.length;i++)
        {
            dset.add(Integer.parseInt(deadends[i]));
        }
        if (dset.contains(0))
        {
            return -1;
        }
        int t=Integer.parseInt(target);
        if (t==0)
            return 0;
        Queue<Integer> q1=new LinkedList<Integer>();
        Queue<Integer> q2=new LinkedList<Integer>();
        q1.offer(0);
        v1.put(0,0);
        q2.offer(t);
        v2.put(t,0);
        while ((q1.size()>0)&&(q2.size()>0))
        {
            int hit=-1;
            if (q1.size()<q2.size())
            {
                hit=bfs(q1,1);
            }
            else
                hit=bfs(q2,2);
            if (hit!=-1)
                return hit;
        }
        return -1;
    }
    
    private int bfs(Queue<Integer> q, int d)
    {
        int wcurrent=q.poll();
        int l=0;
        if (d==1)
            l=v1.get(wcurrent)+1;
        else
            l=v2.get(wcurrent)+1;
        HashSet<Integer> nexts=generateNext(wcurrent);
        for (int v:nexts)
        {
            if (d==1)
            {
                if (v2.containsKey(v))
                    return l+v2.get(v);
                else if ((!dset.contains(v))&&(!v1.containsKey(v)))
                {
                    v1.put(v,l);
                    q.offer(v);
                }
            }
            else
            {
                if (v1.containsKey(v))
                    return l+v1.get(v);
                else if ((!dset.contains(v))&&(!v2.containsKey(v)))
                {
                    v2.put(v,l);
                    q.offer(v);
                }
            }
        }
        return -1;
    }
    
    private HashSet<Integer> generateNext(int current){
        HashSet<Integer> newset=new HashSet<Integer>();
        int v1=current/1000;
        int v2=(current/100)%10;
        int v3=(current/10)%10;
        int v4=current%10;
        newset.add(((v1+1)%10)*1000+v2*100+v3*10+v4);
        newset.add(((v1+9)%10)*1000+v2*100+v3*10+v4);
        newset.add(((v2+1)%10)*100+v1*1000+v3*10+v4);
        newset.add(((v2+9)%10)*100+v1*1000+v3*10+v4);
        newset.add(((v3+1)%10)*10+v1*1000+v2*100+v4);
        newset.add(((v3+9)%10)*10+v1*1000+v2*100+v4);
        newset.add(((v4+1)%10)+v1*1000+v2*100+v3*10);
        newset.add(((v4+9)%10)+v1*1000+v2*100+v3*10);
        return newset;
    }
}