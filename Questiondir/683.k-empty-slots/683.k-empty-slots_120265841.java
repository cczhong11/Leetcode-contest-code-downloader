class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < flowers.length; i++) {
            int f = flowers[i];
            Integer ceil = ts.ceiling(f), floor = ts.floor(f);
            if (ceil != null && ceil == f + k + 1) return i + 1;
            if (floor != null && floor == f - k - 1) return i + 1;
            ts.add(f);
        }
        return -1;
    }
}