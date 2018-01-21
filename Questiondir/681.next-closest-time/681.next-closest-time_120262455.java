class Solution {
    public String nextClosestTime(String time) {
        Set<Character> chs = time.chars().mapToObj(e->(char)e).collect(Collectors.toSet());
        String[] hhmm = time.split(":");
        while (true) {
            time = nextTime(time);
            Set<Character> newChs = time.chars().mapToObj(e->(char)e).collect(Collectors.toSet());
            if (chs.containsAll(newChs)) {
                return time;
            }
        }
    }
    private String nextTime(String time) {
        String[] hm = time.split(":");
        int h = Integer.valueOf(hm[0]);
        int m = Integer.valueOf(hm[1]);
        m++;
        if (m >= 60) {
            m = 0;
            h++;
        }
        if (h >= 24) {
            h = 0;
        }
        return String.format("%02d:%02d", h, m);
    }
}