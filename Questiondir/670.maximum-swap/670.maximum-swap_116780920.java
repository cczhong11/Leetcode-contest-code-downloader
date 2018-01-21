class Solution {
    public int maximumSwap(int num) {
        if(num==0)
            return 0;
        int cNum=num;
        List<Integer> digs = new ArrayList<Integer>();
        while(cNum>0) {
            digs.add(cNum%10);
            cNum/=10;
        }
        for(int i=digs.size()-1; i>=0; --i) {
            //get lower dig higher than current dig
            int maxI=i;
            for(int j=0; j<i; ++j)
                if(digs.get(j)>digs.get(maxI))
                    maxI=j;
            if(i!=maxI) {
                int temp=digs.get(i);
                digs.set(i, digs.get(maxI));
                digs.set(maxI, temp);
                cNum=0;
                for(int j=digs.size()-1; j>=0; --j)
                    cNum=cNum*10+digs.get(j);
                return cNum;
            }
        }
        return num;
    }
}