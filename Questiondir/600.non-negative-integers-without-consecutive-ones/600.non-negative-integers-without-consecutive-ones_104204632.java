import java.util.*;
import java.math.*;

public class Solution {


    String s;
    Integer[][] f;

    int F(int len, int free) {
        if (len >= s.length()) {
            return 1;
        }
        if (f[len][free] != null)
            return f[len][free];

        char high = free == 1 ? '1' : s.charAt(len);
//        System.out.println(len + " " + free + " " +  high);
        int ans = F(len + 1, free == 1 || s.charAt(len) == '1' ? 1 : 0);
        if (high == '1') {
            ans += F(len + 2, free == 1 || (len + 1 < s.length() && s.charAt(len + 1) == '1') ? 1 : 0);
        }

        f[len][free] = ans;
        return ans;
    }

    public int findIntegers(int num) {
        s = Integer.toBinaryString(num);
//        System.out.println(s);
        f = new Integer[55][3];
        return F(0, 0);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        for (int i=1; i<=10; i++)
            System.out.println(i + " " + sol.findIntegers(i));
        System.out.println(sol.findIntegers(1000000000));
    }
}