public class Solution {
    class Offer implements Comparable<Offer> {
        List<Integer> orig;
        List<Integer> spec;
        int diff;
        Offer(List<Integer> orig, List<Integer> list) {
            this.orig = orig;
            this.spec = list;
            int size = list.size();
            int price = list.get(size - 1);
            int sum = 0;
            for (int i = 0; i < size - 1; i++) {
                sum += list.get(i) * orig.get(i);
            }
            diff = sum - price;
        }
        int get(int i) {
            return this.spec.get(i);
        }
        int getPrice() {
            return this.spec.get(spec.size() - 1);
        }
        public int compareTo(Offer o) {
            return o.diff - diff;
        }
    }
    int res = Integer.MAX_VALUE;
    List<Integer> p;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        p = price;
        List<Offer> arr = new ArrayList<>();
        for (List<Integer> list : special) {
            Offer off = new Offer(price, list);
            if (off.diff < 0) continue;
            arr.add(off);
        }
        Collections.sort(arr);
        List<Integer> curr = new ArrayList<>();
        for (int i : needs) curr.add(0);
        dfs(arr, 0, 0, curr, needs);
        return res;
    }
    boolean dfs(List<Offer> arr, int start, int total, List<Integer> curr, List<Integer> needs) {
        if (start == arr.size()) {
            int diff = 0;
            for (int i = 0; i < curr.size(); i++) {
                if (curr.get(i) != needs.get(i)) {
                    diff += p.get(i) * (needs.get(i) - curr.get(i));
                }
            }
            res = Math.min(res, total + diff);
            return diff == 0;
        }
        boolean fit = true;
        Offer off = arr.get(start);
        List<Integer> copy = new ArrayList<>(curr);
        for (int i = 0; i < curr.size(); i++) {
            curr.set(i, curr.get(i) + off.get(i));
            if (curr.get(i) > needs.get(i)) {
                fit = false;
                break;
            }
        }
        if (fit) {
            fit = dfs(arr, start, total + off.getPrice(), curr, needs);
        }
        cp(curr, copy);
        if (!fit)
            fit = dfs(arr, start + 1, total, curr, needs);
        return fit;
    }
    void cp(List<Integer> a, List<Integer> b) {
        for (int i = 0; i < a.size(); i++) {
            a.set(i, b.get(i));
        }
    }
}