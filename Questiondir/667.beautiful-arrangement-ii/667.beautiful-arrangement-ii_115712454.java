class Solution {
    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        int i;
        for (i = 0; i < n-k; i++) {
            result[i] = i+1;
        }
        int sign = 1;
        while (k > 0) {
            result[i] = result[i-1] + sign*k;
            k--;
            i++;
            sign = -sign;
        }
        return result;
    }
}