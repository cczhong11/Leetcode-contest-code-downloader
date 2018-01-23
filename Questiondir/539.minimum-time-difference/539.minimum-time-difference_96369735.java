public class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] time = new int[timePoints.size()];
        int i = 0;
        for (String s : timePoints) {
            time[i++] = time(s);
        }
        Arrays.sort(time);
        int min = 500000;
        for (int j = 0; j < time.length - 1; j++) {
            min = Math.min(min, time[j+1] - time[j]);
            if (min == 0)
                return 0;
        }
        min = Math.min(min, time[0] + 24 * 60 - time[time.length-1]);
        return min;
    }
    
    private int time(String s) {
        String[] ss = s.split(":");
        return Integer.parseInt(ss[0]) * 60 + Integer.parseInt(ss[1]);
    }
}