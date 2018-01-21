public class Solution {
    public boolean canPlaceFlowers(int[] b, int n) {
        if(n==0) return true;
        if(b==null || b.length < n) return false;
        for(int i=0;i<b.length;i++) {
            if(b[i] == 1) continue;
            if(i>0 && b[i-1] == 1) continue;
            if(i<b.length-1 && b[i+1] == 1) continue;
            b[i] = 1;
            if(--n == 0) return true; 
        }
        return false;
    }
}