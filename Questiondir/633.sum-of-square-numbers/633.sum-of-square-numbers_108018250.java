public class Solution {
    public boolean judgeSquareSum(int C) {
        long c = C;
        for (long i = 0; i * i <= c; i++) {
            long b = c - i * i;
            long sb = (long) Math.sqrt(b * 1.0);
            if (sb * sb == b) return true;
        }
        return false;
    }
}