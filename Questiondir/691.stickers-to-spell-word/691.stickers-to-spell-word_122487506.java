class Solution {
    String s[];
    String T;
    int memo[];
    int MAX;
    public int minStickers(String[] stickers, String target) {
        MAX = Integer.MAX_VALUE-5;
        memo=new int[(1<<16)+1];
        s=stickers;
        T=target;
        int ans = find(0);
        if (ans==MAX)return -1;
        return ans;
    }
    
    public int find(int bitmask) {
        if (bitmask==(1<<T.length())-1) {
            return 0;
        }
        if (memo[bitmask]>0)return memo[bitmask]-1;
        int min = MAX;
        for(int i=0;i<s.length;i++) {
            int newpossiblebitmask=use(i,T,bitmask);
            if (newpossiblebitmask!=bitmask) {
                min = Math.min(min, 1+find(newpossiblebitmask));
            }
        }
        memo[bitmask]=1+min;
        return min;
    }
    
    public int use(int pos, String target, int bitmask) {
        int counts[]=new int[200];
        for(int i=0;i<s[pos].length();i++)counts[s[pos].charAt(i)]++;
        int newbitmask = 0;
        for(int i=0;i<target.length();i++) {
            if ((bitmask&(1<<i))==0) {
                if (counts[target.charAt(i)]-->0) {
                    newbitmask |= 1<<i;
                }
            } else {
                newbitmask |= 1<<i;
            }
        }
        return newbitmask;
    }
}