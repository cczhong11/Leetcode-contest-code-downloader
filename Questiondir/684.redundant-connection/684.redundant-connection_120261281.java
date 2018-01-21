class Solution {
    public int find(int x, int [] f){
        if(f[x] != x)
            f[x] = find(f[x], f);
        return f[x];
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        int [] f = new int [2001];
        for(int i = 1; i <= 2000; i++)
            f[i] = i;
        for(int [] i : edges){
            int le = find(i[0], f), ri = find(i[1], f);
            if(le == ri){
                int [] ans = {i[0], i[1]};
                return ans;
            }
            f[le] = ri;
        }
        return null;
    }
}