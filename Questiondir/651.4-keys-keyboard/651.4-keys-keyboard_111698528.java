public class Solution {
    public int maxA(int N) {
        if(N<7) {
            return N;
        }
        int[] res = new int[N+1];
        for(int i=1;i<7;i++) {
            res[i] = i;
        }
        for(int i=7;i<N+1;i++) {
            res[i] = Math.max(Math.max(Math.max(2*res[i-3],3*res[i-4]),4*res[i-5]),5*res[i-6]);
        }
        return res[N];
    }
}