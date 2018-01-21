class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < flowers.length; ++i) {
            int flower = flowers[i];
            set.add(flower);
            Integer lower = set.lower(flower);
            Integer higher = set.higher(flower);
            if (lower != null && flower - lower == k + 1 || higher != null && higher - flower == k + 1) 
                return i + 1;
        }
        return -1;
    }
}