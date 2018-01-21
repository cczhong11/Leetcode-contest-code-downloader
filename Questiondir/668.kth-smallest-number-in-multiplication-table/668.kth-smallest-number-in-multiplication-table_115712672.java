class Solution {
    public int findKthNumber(int m, int n, int k) {
        if (k == 1) return 1;
        if (k == m * n) return m * n;
        int l = 1;
        int r = m * n;
        while (l < r) {
            int mid = (l + r) / 2;
            if (le(n, m, mid) >= k) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int le(int n, int m, int x) {
        if (n > m) {
            int temp = n;
            n = m;
            m = temp;
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += calc(i, m, x);
        }
        return ans;
    }

    private int calc(int fix, int var, int x) {
        if (x < fix) return 0;
        if (x >= fix * var) return var;
        int l = 1;
        int r = var;
        while (l < r) {
            int m = (l + r + 1) / 2;
            if (fix * m <= x) {
                l = m;
            }
            else {
                r = m - 1;
            }
        }
        return l;
    }
}