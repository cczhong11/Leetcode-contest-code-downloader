class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        TreeMap<Integer, Integer> slots = new TreeMap<>();
        int n = flowers.length;
        slots.put(0, n + 1);
        for (int i = 0; i < flowers.length; i++) {
            int f = flowers[i];
            int l = slots.floorKey(f);
            int r = slots.get(l);
            if (f - l == k + 1 && l > 0) {
                return i + 1;
            }
            if (r - f == k + 1 && r <= n) {
                return i + 1;
            }
            slots.remove(l);
            if (f - l > 1) {
                slots.put(l, f);
            }
            if (r - f > 1) {
                slots.put(f, r);
            }
        }
        return -1;
    }
}