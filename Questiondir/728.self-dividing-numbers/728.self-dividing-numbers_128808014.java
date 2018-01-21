class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ll=new LinkedList<Integer>();
        for (int k=left;k<=right;k++)
        {
            int r=k%10;
            int j=k/10;
            boolean flag=true;
            if (r==0)
                continue;
            if (k%r!=0)
                continue;
            while (j>0)
            {
                r=j%10;
                j=j/10;
                if ((r==0)||(k%r!=0))
                {
                    flag=false;
                    break;
                }
            }
            if (flag)
            {
                ll.add(k);
            }
        }
        return ll;
    }
}