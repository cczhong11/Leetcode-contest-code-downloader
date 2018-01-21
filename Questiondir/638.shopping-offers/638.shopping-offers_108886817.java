public class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> dp = new HashMap<>();
        List<List<Integer>> picks = new ArrayList<>(special);
        int n = price.size();
        for (int i = 0; i < n; i++) {
            List<Integer> pick = new ArrayList<>();
            for (int j = 0; j < n; j++) pick.add(0);
            pick.set(i, 1);
            pick.add(price.get(i));
            picks.add(pick);
        }
        List<Integer> zero = new ArrayList<>();
        for (int j = 0; j < n; j++) zero.add(0);
        dp.put(zero, 0);
        for (List<Integer> pick : picks) {
            dfs(Collections.emptyList(), 0, n, pick, dp, needs);
        }
        return dp.get(needs);
    }

    private void dfs(List<Integer> array, int cur, int n, List<Integer> pick, Map<List<Integer>, Integer> dp, List<Integer> needs) {
        if (cur == n) {
            if (dp.containsKey(array)) {
                int old = dp.get(array) + pick.get(n);
                for (int i = 0; i < n; i++) {
                    array.set(i, array.get(i) + pick.get(i));
                }
                dp.put(array, Math.min(old, dp.getOrDefault(array, Integer.MAX_VALUE)));
            }
            return;
        }
        for (int i = 0; i <= needs.get(cur) - pick.get(cur); i++) {
            List<Integer> next = new ArrayList<>(array);
            next.add(i);
            dfs(next, cur + 1, n, pick, dp, needs);
        }
    }
}