import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.monotoneIncreasingDigits(10));
        System.out.println(sol.monotoneIncreasingDigits(1234));
        System.out.println(sol.monotoneIncreasingDigits(332));

        for (int i = 0; i < 50000; i++) {
            int ans = 0;
            for (int j = i; j >= 0; j--)
                if (is(j)) {
                    ans = j;
                    break;
                }
            if (ans != sol.monotoneIncreasingDigits(i)) {
                System.out.println("Failed at " + i);
            }

        }
    }

    static boolean is(int n) {
        String s = "" + n;
        for (int i = 0; i < s.length() - 1; i++)
            if (s.charAt(i) > s.charAt(i + 1)) return false;
        return true;
    }

    public int monotoneIncreasingDigits(int N) {
        if (N < 10) return N;


        char[] s = ("" + N).toCharArray();
        for (int i = 0; i < s.length - 1; i++) {
            if (s[i] > s[i + 1]) {
                char val = s[i];

                for (int j = i; j >= 0; j--)
                    if (s[j] == val) {
                        s[j] = (char) (val - 1);
                        if (j + 1 < s.length) s[j + 1] = '9';
                    }

                for (int j = i + 1; j < s.length; j++)
                    s[j] = '9';
                break;
            }
        }

        int ans = 0;
        for (char ch : s)
            ans = ans * 10 + ch - '0';
        return ans;
    }
}