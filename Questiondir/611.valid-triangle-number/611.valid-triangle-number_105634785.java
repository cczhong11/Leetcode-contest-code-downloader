public class Solution {
    public int triangleNumber(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        int res = 0;
        for (int i = n - 1; i >= 2; i--) {
            int k = 0;
            int j = i - 1;
            while (k < j) {
                if (a[k] + a[j] <= a[i]) {
                    res += j - k;
                    k++;
                } else {
                    j--;
                }
            }
        }
        return (n * (n - 1) * (n - 2)) / 6 - res;
    }
}