class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        set.add(flowers.length + 1);
        for (int i = 0; i < flowers.length; i++) {
            int num = flowers[i];
            int up = set.ceiling(num);
            if (up - num - 1 == k && up != flowers.length + 1) return i + 1;
            int down = set.floor(num);
            if (num - down - 1== k && down != 0) return i + 1;
            set.add(num);
        }
        return -1;
    }
}