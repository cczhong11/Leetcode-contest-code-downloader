class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < flowers.length; i++) {
            Integer lower = set.lower(flowers[i]);
            Integer higher = set.higher(flowers[i]);
            set.add(flowers[i]);
            if (lower != null && flowers[i] - lower - 1 == k) return i+1;
            if (higher != null && higher - flowers[i] -1 == k) return i+1;
        }
        return -1;
    }
}