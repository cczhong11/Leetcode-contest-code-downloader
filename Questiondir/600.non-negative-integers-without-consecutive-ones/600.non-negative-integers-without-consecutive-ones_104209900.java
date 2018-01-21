public class Solution {
    public int findIntegers(int num) {
        int[] a = new int[33], b = new int[33];
        a[0] = 1;
        b[0] = 1;
        for (int i = 1, n = a.length; i < n; i++) {
            a[i] = b[i - 1] + a[i - 1];
            b[i] = a[i - 1];
        }
        int[] bi = getBinary(num);
        int bit = 31, ans = 0;
        while (true) {
            while (bit >= 0 && bi[bit] == 0) bit--;
            if (bit < 0) {
                ans++;
                break;
            }
            ans += a[bit--];
            if (bit >= 0 && bi[bit] == 1) {
                ans += a[bit];
                break;
            }
        }
        return ans;
    }

    int[] getBinary(int num) {
        char[] ch = Integer.toBinaryString(num).toCharArray();
        int[] res = new int[32];
        for (int i = 0, bias = ch.length - 1; i < ch.length; i++) {
            res[bias - i] = ch[i] - '0';
        }
        return res;
    }
}