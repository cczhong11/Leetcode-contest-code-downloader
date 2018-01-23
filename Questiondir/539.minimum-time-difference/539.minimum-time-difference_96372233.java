public class Solution {
    private class Time implements Comparable<Time> {
        int hour;
        int min;
        Time(int h, int m) {
            hour = h;
            min = m;
        }
        public int compareTo(Time other) {
            if(this.hour != other.hour) return this.hour - other.hour;
            return this.min - other.min;
        }
    }
    public int findMinDifference(List<String> timePoints) {
        if(timePoints == null || timePoints.size() < 2) return 0;
        List<Time> times = new ArrayList<>(timePoints.size());
        for(String point : timePoints) {
            String[] str = point.split(":");
            Time time = new Time(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
            times.add(time);
        }
        Collections.sort(times);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < times.size(); i++) {
            int diff = (times.get(i).hour - times.get(i - 1).hour) * 60 + times.get(i).min - times.get(i - 1).min;
            min = Math.min(min, diff);
        }
        Time t = times.get(0), p = times.get(times.size() - 1);
        t.hour += 24;
        int diff = (t.hour - p.hour) * 60 + t.min - p.min;
        min = Math.min(diff, min);
        return min;
    }
}