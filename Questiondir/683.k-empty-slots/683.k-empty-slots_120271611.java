class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        final int n = flowers.length;
        TreeSet<Integer> bloom = new TreeSet<>();
        bloom.add(0);
        bloom.add(n + 1);
        for (int i = 0; i < n; ++i) {
            int f = flowers[i];
            int lo = bloom.lower(f);
            int hi = bloom.higher(f);
            if ((lo != 0 && f - lo - 1 == k) || (hi != n + 1 && hi - f - 1 == k)) {
                return i + 1;
            }
            bloom.add(f);
        }
        return -1;
    }
}