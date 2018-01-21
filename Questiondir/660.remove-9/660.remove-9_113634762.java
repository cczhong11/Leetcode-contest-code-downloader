public class Solution {
    public int newInteger(int n) {

        int low = 0;
        int high = Integer.MAX_VALUE;

        while (true) {

            int mid = (low + high) >>> 1;
            int cnt = getRangeNum(mid);
            if (cnt > n) {
                high = mid - 1;
            } else if (cnt < n) {
                low = mid + 1;
            } else {
                if (contains9(mid)) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            }
        }
    }

    public boolean contains9(int n) {
        while (n > 0) {
            int mod = n % 10;
            if (mod == 9) {
                return true;
            }
            n = n / 10;
        }
        return false;
    }

    public int getRangeNum(int n) {

        if (n <= 8) {
            return n;
        }

        if (n == 9) {
            return 8;
        }

        int highest = getHighest(n);
        if (highest == n) {
            return 1 + getRangeNum(n - 1);
        }

        if (n / highest == 9) {
            return getRangeNum(9 * highest - 1);
        }

        return (n / highest) * getRangeNum(highest) +
                getRangeNum(n - (n / highest) * highest) ;
    }

    private int getHighest(int n) {
        int res = 1;
        while (n >= 10) {
            res *= 10;
            n /= 10;
        }
        return res;
    }
}