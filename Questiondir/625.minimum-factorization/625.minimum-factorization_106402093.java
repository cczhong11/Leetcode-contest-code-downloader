import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {

    Map<List<Integer>, Long> f = new HashMap<>();

    private long f(List<Integer> factor) {
        int two = factor.get(0);
        int three = factor.get(1);

        if (two == 0 && three == 0) return 0;
        if (f.containsKey(factor)) return f.get(factor);
        long ans = Long.MAX_VALUE;

        if (two >= 1) {
            ans = Math.min(ans, f(Arrays.asList(two - 1, three)) * 10 + 2);
        }
        if (two >= 2) {
            ans = Math.min(ans, f(Arrays.asList(two - 2, three)) * 10 + 4);
        }
        if (two >= 3) {
            ans = Math.min(ans, f(Arrays.asList(two - 3, three)) * 10 + 8);
        }
        if (three >= 1) {
            ans = Math.min(ans, f(Arrays.asList(two, three - 1)) * 10 + 3);
        }
        if (three >= 2) {
            ans = Math.min(ans, f(Arrays.asList(two, three - 2)) * 10 + 9);
        }
        if (two >= 1 && three >= 1) {
            ans = Math.min(ans, f(Arrays.asList(two - 1, three - 1)) * 10 + 6);
        }

        f.put(factor, ans);
        return ans;
    }

    public int smallestFactorization(int a) {
        if (a == 1) return 1;
        
        
        int[] cnt = new int[10];
        for (int i = 2; i < 10; i++) {
            while (a % i == 0) {
                a /= i;
                cnt[i]++;
            }
        }

        if (a > 1) return 0;

        String ans = f(Arrays.asList(cnt[2], cnt[3])) + "";
        for (int i = 0; i < cnt[5]; i++)
            ans += '5';
        for (int i = 0; i < cnt[7]; i++)
            ans += '7';
        char[] s = ans.toCharArray();
        Arrays.sort(s);
        ans = String.copyValueOf(s);

        try {
            int hehe = Integer.parseInt(ans);
            return hehe;
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.smallestFactorization(2 * 8 * 8 * 5));
    }

}