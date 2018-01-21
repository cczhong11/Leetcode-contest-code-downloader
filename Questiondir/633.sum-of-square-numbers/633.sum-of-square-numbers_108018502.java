public class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        for (long i = 0; i * i <= c * 1l; i++) {
            if (isSquare(c - i *i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSquare(long c) {
        return (int)Math.sqrt(c) * (int)Math.sqrt(c) == c;
    }
}