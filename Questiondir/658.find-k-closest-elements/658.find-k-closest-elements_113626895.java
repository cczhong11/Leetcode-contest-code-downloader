public class Solution {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        TreeMap<Integer, Integer> ts = new TreeMap<>();
        for (int v : arr) {
            ts.put(v, 1 + ts.getOrDefault(v, 0));
        }
        
        // System.out.println(ts);
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            Integer lo = ts.lowerKey(x + 1);
            Integer hi = ts.higherKey(x - 1);
            // System.out.format("i = %d, lo = %d, hi = %d\n", i, lo, hi);
            int which;
            if (lo == null) {
                which = hi;
            } else if (hi == null) {
                which = lo;
            } else if (x - lo <= hi - x) {
                which = lo;
            } else {
                which = hi;
            }
            ans.add(which);
            int prev = ts.get(which);
            if (prev == 1) {
                ts.remove(which);
            } else {
                ts.put(which, prev - 1);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}