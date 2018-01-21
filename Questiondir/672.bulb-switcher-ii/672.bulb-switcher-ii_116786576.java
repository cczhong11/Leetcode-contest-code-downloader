import java.util.*;
import java.math.*;
import java.util.stream.*;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.flipLights(1, 1));
        System.out.println(sol.flipLights(2, 1));
        System.out.println(sol.flipLights(3, 1));

    }

    public int flipLights(int n, int m) {
        if (n == 0 || m == 0) return 1;

        Set<BitSet> set = new HashSet<>();
        BitSet all = new BitSet(n);
        BitSet odd = new BitSet(n);
        BitSet even = new BitSet(n);
        BitSet other = new BitSet(n);
        for (int i = 0; i < n; i++) {
            all.set(i);
            if (i % 2 == 0) {
                even.set(i);
            }
            if (i % 2 == 1) {
                odd.set(i);
            }
            if (i % 3 == 0) {
                other.set(i);
            }
        }
//        System.out.println(all);
//        System.out.println(odd);
//        System.out.println(even);
//        System.out.println(other);

        for (int mask = 0; mask < (1 << 4); mask++) {
            if (Integer.bitCount(mask) <= m && (m - Integer.bitCount(mask)) % 2 == 0) {
                BitSet bits = new BitSet(n);
                bits.set(0, n);
                for (int i = 0; i < 4; i++) {
                    if (((1 << i) & mask) != 0) {
                        if (i == 0) {
                            bits.xor(all);
                        } else if (i == 1) {
                            bits.xor(odd);
                        } else if (i == 2) {
                            bits.xor(even);
                        } else {
                            bits.xor(other);
                        }
                    }
                }
                set.add(bits);
            }
        }

//        System.out.println(set);
        return set.size();
    }
}
