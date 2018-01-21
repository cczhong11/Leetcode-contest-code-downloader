class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> ts = new TreeSet<>();
        for(int i = 0; i < flowers.length; i++) {
            int num = flowers[i];
            Integer floor = ts.floor(num);
            Integer ceiling = ts.ceiling(num);
            if(floor != null && num - floor == k + 1 || ceiling != null && ceiling - num == k + 1) {
                return i + 1;
            }
            ts.add(num);
        }
        
        return -1;
    }
}