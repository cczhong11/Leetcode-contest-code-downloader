class Solution {
       String toKey(int[] arr){
        StringBuilder sb=new StringBuilder();
        boolean allZ=true;
        for (int i=0;i<26;++i){
            int n=arr[i];
            sb.append(n).append(",");
            if (n>0)allZ=false;
        }
        if (allZ)return "";
        return sb.toString();
    }
    public int minStickers(String[] stickers, String target) {
        if (target.isEmpty())return 0;
        int ns=stickers.length;
        int tl=target.length();
        int[][][]dp=new int[ns][tl+1][26];
        int[][] letters=new int[ns][26];
        for (int i=0;i<stickers.length;++i){
            String s=stickers[i];
            for (char c:s.toCharArray())++letters[i][c-'a'];
        }
        int[] targetLetters=new int[27];
        for (char c:target.toCharArray())++targetLetters[c-'a'];
        targetLetters[26]=0;
        String key=toKey(targetLetters);
        int ans=0;
        if (key.isEmpty())return 0;
        Queue<int[]>q=new LinkedList<>();
        Set<String> seenKey= new HashSet<>();
        seenKey.add(key);
        q.add(targetLetters);
        while (!q.isEmpty()){
            int[]cur=q.remove();
            for (int i=0;i<ns;++i){
                int[] next=cur.clone();
                int[]letter=letters[i];
                for (int j=0;j<26;++j){
                    if (letter[j]>=0)
                        next[j]=Math.max(next[j]-letter[j], 0);
                }
                ++next[26];
                String nextKey=toKey(next);
                if (nextKey.isEmpty())return next[26];
                if (seenKey.add(nextKey)){
//                    log.info("add key: {}", nextKey);
                    q.add(next);
                }
            }
        }
        return -1;
    }
}