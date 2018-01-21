class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        List<Interval> list = new ArrayList<>();
        int max = 0;
        for (int[] pos: positions) {
            int start = pos[0];
            int end = pos[0] + pos[1] - 1;
            int height = pos[1];
            Interval cur = new Interval(start, end, height);
            
            int highest = 0;
            for (Interval interval: list) {
                if (cur.start > interval.end || interval.start > cur.end) {
                    continue;
                }
                highest = Math.max(highest, interval.height);
            }
            cur.height += highest;
            max = Math.max(max, cur.height);
            ans.add(max);
            list.add(cur);
        }
        return ans;
    }
    
    class Interval {
        int start;
        int end;
        int height;
        public Interval(int s, int e, int h) {
            start = s;
            end = e;
            height = h;
        }
    }
}