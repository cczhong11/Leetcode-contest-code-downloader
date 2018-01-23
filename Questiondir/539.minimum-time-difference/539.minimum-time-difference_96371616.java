public class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = getMinutes(timePoints.get(i));
        }
        Arrays.sort(times);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int diff = 0;
            if (i == 0) {
                diff = times[i] + 24 * 60 - times[n-1];
            } else {
                diff = times[i] - times[i-1];
            }
            min = Math.min(diff, min);
        }
        return min;
    }
    
    private int getMinutes(String time) {
        String[] t = time.split(":");
        return Integer.valueOf(t[0]) * 60 + Integer.valueOf(t[1]);
    }
}