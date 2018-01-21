class Solution {
    List<boolean[]> answers;
    int n, c;
    boolean[] set;
    boolean[] isOn;
    
    public int flipLights(int n1, int m) {
        if(m==0)
            return 1;
        n=n1;
        c=m;
        answers = new ArrayList<boolean[]>();
        set = new boolean[n];
		isOn = new boolean[n];
        recur(0);
        return answers.size();
    }
    
    void recur(int state) {
        boolean[] lamps = new boolean[n];
        if((state&1)==0)
            Arrays.fill(lamps, true);
        if((state&2)!=0)
            for(int i=0; i<n; i+=2)
                lamps[i]=!lamps[i];
        if((state&4)!=0)
            for(int i=1; i<n; i+=2)
                lamps[i]=!lamps[i];
        if((state&8)!=0)
            for(int i=0; i<n; i+=3)
                lamps[i]=!lamps[i];
        int switches=Integer.bitCount(state);
        if(switches==c||switches<c-1) {
            boolean works=true;
            for(int i=0; i<n; ++i) {
                if(set[i]&&lamps[i]!=isOn[i]) {
                    works=false;
                    break;
                }
            }
            if(works) {
                for(boolean[] ans : answers) {
                    boolean dif=false;
                    for(int i=0; i<n; ++i) {
                        if(ans[i]!=lamps[i]) {
                            dif=true;
                            break;
                        }
                    }
                    if(dif==false) {
                        works=false;
                        break;
                    }
                }
            }
            if(works)
                answers.add(lamps);
        }
        if(switches==c)
            return;
        if((state&1)==0&&(state&6)!=6)
            recur(state|1);
        if((state&2)==0&&(state&5)!=5)
            recur(state|2);
        if((state&4)==0&&(state&3)!=3)
            recur(state|4);
        if((state&8)==0)
            recur(state|8);
	}
}