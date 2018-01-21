public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minr = m, minc = n;
        for(int[] op : ops){
            minr = Math.min(minr, op[0]);
            minc = Math.min(minc, op[1]);
        }
        return minr*minc;
    }
}