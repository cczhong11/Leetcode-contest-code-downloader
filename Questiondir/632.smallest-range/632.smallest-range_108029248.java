public class Solution {
     class wrap implements Comparable<wrap>{
        int index;
        int []nums;
        int label;
        wrap(int []nums, int index, int label) {
            this.index = index;
            this.nums = nums;
            this.label = label;
        }
        public int cur() {
            return nums[index];
        }

        @Override
        public int compareTo(wrap o) {

            int cmp = Integer.compare(this.nums[this.index],o.nums[o.index]);
            if (cmp == 0) {
                return Integer.compare(label, o.label);
            }
            return cmp;
        }
    }
    public int[] smallestRange(int[][] nums) {
        TreeSet<wrap> pq = new TreeSet<wrap>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(new wrap(nums[i], 0,i));
        }
        int []range = {pq.first().cur(), pq.last().cur()};

        while (pq.size() == nums.length) {
            wrap w = pq.first();
            wrap l = pq.last();
            if (range[1] - range[0] > l.cur() - w.cur()) {
                range[0] = w.cur();
                range[1] = l.cur();

            } else if (range[1] - range[0] == l.cur() - w.cur()) {
                if (range[0] > w.cur()) {
                    range[0] = w.cur();
                    range[1] = l.cur();
                }
            }
            pq.remove(w);
            if (w.index + 1 < w.nums.length) {
                pq.add(new wrap(w.nums, w.index + 1, w.label));
            }


        }
        return range;
    }
}