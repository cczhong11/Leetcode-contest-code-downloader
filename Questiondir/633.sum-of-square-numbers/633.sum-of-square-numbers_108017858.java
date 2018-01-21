import java.util.Arrays;

public class Solution {
    private boolean isSqr(int n) {
        long a = (long) Math.sqrt(n);
        return a * a == n || (a - 1) * (a - 1) == n || (a + 1) * (a + 1) == n;
    }

    public boolean judgeSquareSum(int c) {
        for (int i = 0; (long) i * i <= c; i++) {
            if (isSqr(c - i * i)) return true;
        }
        return false;
    }
}