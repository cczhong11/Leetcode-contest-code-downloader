public class Solution {
    public int maxA(int N) {
        if(N > 10) return Math.max(3*maxA(N-4), 4*maxA(N-5));
        else if(N < 7) return N;
        else if(N == 7) return 9;
        else if(N == 8) return 12;
        else if(N == 9) return 16;
        else return 20;
    }
}