public class Solution {
    public boolean judgeSquareSum(int c0) {
        long c = c0;
        for (long i = 0; i * i <= c; i++) {
            long remain = c - i * i;
            if (isSqr(remain)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSqr(long n) {
        long d = (long) Math.sqrt(n + 0.5);
        return d * d == n;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().judgeSquareSum(5));
    }
}