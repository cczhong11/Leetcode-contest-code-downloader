class Solution {
    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m * n;
        while (left < right) {
            int mid = (left + right) / 2;
            if (numsTillLevel(mid, m, n) < k) left = mid+1;
            else right = mid;
        }
        return left;
    }
    
    public static int numsTillLevel(int num, int m, int n) {
        int nums = 0;
        for (int i = 1; i <= n; i++) {
            nums += Math.min(m, num / i);
        }
        return nums;
    }
}