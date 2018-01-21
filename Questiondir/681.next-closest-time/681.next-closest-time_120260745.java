class Solution {
    private static final int DAY = 24 * 60;
    public String nextClosestTime(String time) {
        String[] hm = time.split(":");
        int h = Integer.parseInt(hm[0]);
        int m = Integer.parseInt(hm[1]);
        Set<Integer> digits = new HashSet<>();
        digits.add(h / 10);
        digits.add(h % 10);
        digits.add(m / 10);
        digits.add(m % 10);
        for (int ts = h * 60 + m + 1; ts != h * 60 + m; ts = (ts + 1) % DAY) {
            int th = ts / 60;
            int tm = ts % 60;
            if (!digits.contains(th / 10) ||
               !digits.contains(th % 10) ||
               !digits.contains(tm / 10) ||
               !digits.contains(tm % 10)) {
                continue;
            }
            return String.format("%02d:%02d", th, tm);
        }
        return time;
    }
}