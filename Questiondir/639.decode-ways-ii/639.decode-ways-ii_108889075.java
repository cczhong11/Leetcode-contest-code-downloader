public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        if (s.charAt(0) == '0') return 0;

        long[] cache = new long[s.length()];
        int mod = (int)Math.pow(10, 9) + 7;
        cache[0] = 1;
        if (s.charAt(0) == '*') cache[0] = 9;
        for (int i = 1 ; i < s.length(); i++) {
            if (s.charAt(i) == '0') if (s.charAt(i - 1) > '3' || s.charAt(i - 1) == '0') return 0;

            if (s.charAt(i - 1) != '0') {
                if (s.charAt(i) == '*') {
                    char prev = s.charAt(i - 1);
                    if (prev == '*' || prev == '1') {
                        if (i - 2 >= 0) {
                            cache[i] += 9 * cache[i - 2];
                        } else {
                            cache[i] += 9;
                        }
                    }
                    if (prev == '*' || prev == '2') {
                        if (i - 2 >= 0) {
                            cache[i] += 6 * cache[i - 2];
                        } else {
                            cache[i] += 6;
                        }
                    }
                } else if (s.charAt(i - 1) == '*') { //parse together?
                    int val = s.charAt(i) - '0';
                    int mult = 0;
                    for (int z = 1; z <= 2; z++) {
                        if ((z * 10) + val <= 26) mult++;
                    }

                    if (i - 2 >= 0) {
                        cache[i] += mult * cache[i - 2];
                    } else {
                        cache[i] += mult;
                    }
                } else if (Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
                    if (i - 2 >= 0) {
                        cache[i] += cache[i - 2];
                    } else {
                        cache[i]++;
                    }
                }
            }

            if (s.charAt(i) == '*') {
                cache[i] += 9 * cache[i - 1];
            } else if (s.charAt(i) != '0') cache[i] += cache[i - 1];

            cache[i] = cache[i] %= mod;
        }
        return (int)cache[s.length() - 1];
    }
}