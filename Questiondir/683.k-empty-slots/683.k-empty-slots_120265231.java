class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < flowers.length; i++) {
            Integer ceiling = set.ceiling(flowers[i]);
            Integer floor = set.floor(flowers[i]);
            if (ceiling != null && flowers[i] + k + 1 == ceiling) {
                return i + 1;
            }
            if (floor != null && flowers[i] == floor + k + 1) {
                return i + 1;
            }
            set.add(flowers[i]);
        }
        return -1;
    }
}