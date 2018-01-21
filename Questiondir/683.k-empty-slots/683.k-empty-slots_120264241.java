import java.util.TreeSet;

class Solution {
    public int kEmptySlots(int[] flowers, int k) {
    	if (k < 0 || flowers.length < 2) {
    		return -1;
    	}
    	++k;
        TreeSet<Integer> set = new TreeSet<Integer>();
        set.add(flowers[0]);
        for (int i = 1; i < flowers.length; ++i) {
        	set.add(flowers[i]);
        	int r1 = flowers[i] - k;
        	if (set.contains(r1) && set.higher(r1) == flowers[i]) return i + 1;
        	int r2 = flowers[i] + k;
        	if (set.contains(r2) && set.lower(r2) == flowers[i]) return i + 1;
        }
        return -1;
    }
}