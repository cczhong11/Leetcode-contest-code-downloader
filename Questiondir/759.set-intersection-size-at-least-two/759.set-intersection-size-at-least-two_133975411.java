class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, SortByR);
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < intervals.length; ++i) {
            int need = 2;
            for (int v : set) {
                if (intervals[i][0] <= v && v <= intervals[i][1]) {
                    --need;
                    if (need <= 0) {
                        break;
                    }
                }
            }
            int what = intervals[i][1];
            while (need > 0) {
                if (!set.contains(what)) {
                    set.add(what);
                    --need;
                }
                --what;
            }
        }
        return set.size();
    }
    
    public static Comparator<int[]> SortByR = new Comparator<int[]>() {
        public int compare(int[] lhs, int[] rhs) {
            int dr = Integer.compare(lhs[1], rhs[1]);
            if (dr != 0) {
                return dr;
            }
            return Integer.compare(lhs[0], rhs[0]);
        }
    };
}