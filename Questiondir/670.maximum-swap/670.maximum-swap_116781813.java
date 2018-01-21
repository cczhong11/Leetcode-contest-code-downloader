import java.util.*;
import java.math.*;
import java.util.stream.*;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.maximumSwap(2736));
        System.out.println(sol.maximumSwap(9973));

    }

    public int maximumSwap(int num) {
        int res = num;
        char[] ch = ("" + num).toCharArray();
        for (int i = 0; i < ch.length; i++)
            for (int j = i + 1; j < ch.length; j++) {
                char tmp = ch[i];
                ch[i] = ch[j];
                ch[j] = tmp;

                long lalala = Long.parseLong(String.valueOf(ch));
                if (lalala <= Integer.MAX_VALUE) {
                    res = Math.max(res, (int) lalala);
                }

                tmp = ch[i];
                ch[i] = ch[j];
                ch[j] = tmp;
            }
        return res;
    }
}
