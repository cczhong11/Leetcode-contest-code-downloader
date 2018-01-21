class Solution {
    int res;
    int n;
    public int minStickers(String[] stickers, String target) {
        n = stickers.length;
        if (n==0)
            return -1;
        
        
        int[][] vectors = new int[n][26];
        for (int i=0; i<n; i++)
            getVector(vectors[i], stickers[i]);
        
        int[] targetVec = new int[26];
        getVector(targetVec, target);
        
        if (!possible(vectors, targetVec))
            return -1;
        
        res = Integer.MAX_VALUE;
        search(vectors, targetVec, 0, 0);
        
        return res;
    }
    
    private boolean possible(int[][] vectors, int[] target){
        int[] sum = new int[26];
        for (int i=0; i<n; i++)
            for (int j=0;j<26;j++)
                sum[j] += vectors[i][j];
        
        for (int i=0;i<26;i++)
            if (target[i]>0 && sum[i]==0)
                return false;
        return true;
    }
    
    private void search(int[][] vectors, int[] target, int cur, int count){
        if (cur==n){
            if (isValid(target))
                res = Math.min(res, count);
            return;
        }
        
        if (count>=res)
            return;
        
        int take = needNum(vectors[cur], target);
        if (take>0){
            minus(target, vectors[cur], take);
            for (int i=take; i>0; i--){
                search(vectors, target, cur+1, count+i);
                plus(target, vectors[cur]);
            }
        }
        
        if (count>=res)
            return;
        
        search(vectors, target, cur+1, count);
    }
    
    private void getVector(int[] v, String str){
        for (int i=0;i<26;i++)
            v[i] = 0;
        
        for (int i=0; i<str.length(); i++)
            v[str.charAt(i)-'a']++;
    }
    
    private int needNum(int[] v, int[] target){
        int need = 0;
        for (int i=0;i<26;i++)
            if (target[i]>0 && v[i]>0){
                if (target[i]%v[i]==0)
                    need = Math.max(need, target[i]/v[i]);
                else
                    need = Math.max(need, target[i]/v[i]+1);
            }
        return need;
    }
    
    private boolean isValid(int[] v){
        for (int i=0;i<26;i++)
            if (v[i]>0)
                return false;
        return true;
    }
    
    private void minus(int[] target, int[] v, int times){
        for (int i=0;i<26;i++)
            target[i] -= v[i] * times;
    }
    
    private void plus(int[] target, int[] v){
        for (int i=0;i<26;i++)
            target[i] += v[i];
    }
}