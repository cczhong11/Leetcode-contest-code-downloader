import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] constructArray(int n, int k) {
        int[] ans = IntStream.rangeClosed(1, n).toArray();
        int[] a = IntStream.rangeClosed(1, k).toArray();
        for (int i = 0, j = k - 1, pos = k - 1; i <= j; ) {
            ans[pos--] = a[i++];
            if (i <= j) {
                ans[pos--] = a[j--];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.constructArray(2, 1)));
        System.out.println(Arrays.toString(sol.constructArray(3, 1)));
        System.out.println(Arrays.toString(sol.constructArray(3, 2)));
        System.out.println(Arrays.toString(sol.constructArray(4, 1)));
        System.out.println(Arrays.toString(sol.constructArray(4, 2)));
        System.out.println(Arrays.toString(sol.constructArray(4, 3)));
        System.out.println(Arrays.toString(sol.constructArray(6, 5)));
    }
}