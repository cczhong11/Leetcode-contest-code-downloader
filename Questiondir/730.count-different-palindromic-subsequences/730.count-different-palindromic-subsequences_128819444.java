class Solution {
    
    public static long MODULO = 1000000007L;
    
    class ModInt {
        private long value;
        
        public ModInt(int v) {value = v;}
        
        public ModInt add(ModInt s) {
            value = value + s.value;
            value = value % MODULO;
            return this;
        }
        
        public ModInt add(int v) { return add(new ModInt(v)); }
        
        public int value() {return (int)(value); }
    }
    
    HashMap<Interval, ModInt> countMap;
    
    class Interval {
        int start, end;
        public Interval(int s, int e) { start = s; end = e;}
        public boolean equals(Object o) {
            if (o instanceof Interval) return equals((Interval)o);
            else return false;
        }
        private boolean equals(Interval v) {
            return (start == v.start && end == v.end);
        }
        public int hashCode() {return (start << 10) + end;}
    }
    
    public int countPalindromicSubsequences(String S) {
        char[] c = S.toCharArray();
        countMap = new HashMap<Interval, ModInt>();
        ModInt ret = helper(c, 0, c.length - 1);
        if(ret==null) return 0;
        else return ret.value();
    }
    
    public ModInt helper(char[] c, int left, int right) {
        if(left>right) return new ModInt(0);
        Interval target = new Interval(left, right);
        ModInt ret = countMap.get(target);
        if (ret!=null) return ret;
        ret = new ModInt(0);
        for(int v=0;v<4;v++) {
            char ch = (char)('a'+v);
            int i = left, j = right;
            while(i<=j && c[i]!=ch) i+=1;
            while(j>=i && c[j]!=ch) j-=1;
            if(j>i && c[i]==ch && c[j]==ch) ret.add(helper(c, i+1, j-1)).add(1);
        }
        int countA = 0, countB = 0, countC = 0, countD = 0;
        for(int i=left;i<=right;i++) {
            switch(c[i]){
                case 'a' : countA = 1;
                    break;
                case 'b' : countB = 1;
                    break;
                case 'c' : countC = 1;
                    break;
                case 'd' : countD = 1;
                    break;
                default :
                    throw new RuntimeException("Invalid character c[" + i + "]=" + c[i]);
            }
        }
        ret.add(countA).add(countB).add(countC).add(countD);
        // System.out.println(" "+left+" "+right + " "+ret.value());
        countMap.put(target, ret);
        return ret;
    }
}