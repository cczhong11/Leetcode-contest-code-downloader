class Solution {
    private int getRank(int r, int c, int value) {
        if (c > r) return getRank(c, r, value);
        int cnt = 0;
        for (int i = 1; i <= c && i <= value; i++) {
            cnt += Math.min(r, value / i);
        }
        return cnt;
    }

    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left <= right) {
            int mid = (int) ((0L + left + right) / 2);
            int rank1 = getRank(n, m, mid - 1);
            int rank2 = getRank(n, m, mid);
            if (rank1 < k && rank2 >= k) return mid;
            else if (rank2 < k) left = mid + 1;
            else right = mid - 1;
        }
//        System.out.println(left + " " + right);
        throw new RuntimeException("shouldn't reach here.");
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        for (int i = 1; i <= 6; i++) {
            System.out.println(sol.findKthNumber(2, 3, i));
        }
    }
}