import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    int[] f;
    List<Integer> price;
    List<List<Integer>> special;
    int inf = Integer.MAX_VALUE;

    int hash(int[] a) {
        int val = 0;
        for (int i : a)
            val = val * 7 + (i);
        return val;
    }

    int f(int[] needs) {
        int key = hash(needs);
        if (f[key] != -1) return f[key];

        int res = inf;
        f[key] = inf;
        for (List<Integer> a : special) {
            boolean canUse = true;
            for (int i = 0; i < needs.length; i++)
                if (needs[i] < a.get(i)) {
                    canUse = false;
                    break;
                }
            if (canUse) {
                for (int i = 0; i < needs.length; i++) {
                    needs[i] -= a.get(i);
                }
                if (f(needs) != inf)
                    res = Math.min(res, f(needs) + a.get(needs.length));
                for (int i = 0; i < needs.length; i++) {
                    needs[i] += a.get(i);
                }
            }
        }

        for (int i = 0; i < needs.length; i++) {
            if (needs[i] > 0) {
                needs[i]--;
                if (f(needs) != inf)
                    res = Math.min(res, f(needs) + price.get(i));
                needs[i]++;
            }
        }

        f[key] = res;
        return res;
    }


    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        f = new int[7 * 7 * 7 * 7 * 7 * 7 + 10];
        Arrays.fill(f, -1);
        this.price = price;
        this.special = special;

        f[0] = 0;
        int[] need = new int[needs.size()];
        for (int i = 0; i < need.length; i++)
            need[i] = needs.get(i);
//        System.out.println(f);
        return f(need);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.shoppingOffers(
                Arrays.asList(2, 5),
                Arrays.asList(
                        Arrays.asList(3, 0, 5),
                        Arrays.asList(1, 2, 10)
                ),
                Arrays.asList(3, 2)
        ));
        System.out.println(sol.shoppingOffers(
                Arrays.asList(2, 3, 4),
                Arrays.asList(
                        Arrays.asList(1, 1, 0, 4),
                        Arrays.asList(2, 2, 1, 9)
                ),
                Arrays.asList(1, 2, 1)
        ));
    }
}