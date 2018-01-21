public class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();
    public int smallestFactorization(int a) {
        if (a < 10) return a;
        if (memo.containsKey(a)) return memo.get(a);
        int fact = 0;
        for (int f = 2; f <= 9; f++) {
            if (a%f != 0) continue;
            int res = smallestFactorization(a/f);
            if (res != 0) {
                long cand = compose(f, res);
                if (cand <= Integer.MAX_VALUE) {
                    fact = fact == 0 ? (int)cand : Math.min(fact, (int)cand);
                }
            }
        }
        memo.put(a, fact);
        return fact;
    }
    long compose(int f, int res) {
        int n = res;
        long ret = f;
        while (n > 0) {
            n /= 10;
            ret *= 10;
        }
        ret += res;
        return ret;
    }
}