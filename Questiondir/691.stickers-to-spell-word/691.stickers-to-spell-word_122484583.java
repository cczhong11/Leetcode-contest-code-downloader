class Solution {
    int min;
    int[][] cnt;
    int[] tCnt;
    
    void recur(int i, int c, int[] cCnt, int j) {
        if(c>min)
            return;
        while(i<26&&cCnt[i]>=tCnt[i])
            ++i;
        if(i>=26) {
            min=c;
            return;
        }
        for(; j<cnt.length; ++j) {
            if(cnt[j][i]==0)
                continue;
            for(int k=i; k<26; ++k)
                cCnt[k]+=cnt[j][k];
            if(cCnt[i]<tCnt[i])
                recur(i, c+1, cCnt, j);
            else
                recur(i+1, c+1, cCnt, 0);
            for(int k=i; k<26; ++k)
                cCnt[k]-=cnt[j][k];
        }
    }
    
    public int minStickers(String[] stickers, String target) {
        min=Integer.MAX_VALUE;
        cnt = new int[stickers.length][26];
        for(int i=0; i<stickers.length; ++i)
            for(char c : stickers[i].toCharArray())
                ++cnt[i][c-'a'];
        tCnt = new int[26];
        for(char c : target.toCharArray())
            ++tCnt[c-'a'];
        for(int i=0; i<26; ++i) {
            if(tCnt[i]==0)
                continue;
            boolean has=false;
            for(int j=0; j<stickers.length; ++j) {
                if(cnt[j][i]>0) {
                    has=true;
                    break;
                }
            }
            if(!has)
                return -1;
        }
        recur(0, 0, new int[26], 0);
        return min;
    }
}