public class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutes = new ArrayList<Integer>();
        for (String time : timePoints) {
            minutes.add(convert(time));
        }
        Collections.sort(minutes, (a, b) -> (a - b));
        return findMin(minutes);
    }

    private int convert(String time) {
        int index = time.indexOf(":");
        int hour = Integer.parseInt(time.substring(0, index));
        int minute = Integer.parseInt(time.substring(index + 1));
        return hour * 60 + minute;
    }

    private int findMin(List<Integer> minutes) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < minutes.size(); i ++) {
            int a = minutes.get(i);
            int b = i + 1 == minutes.size() ? minutes.get(0) : minutes.get(i + 1);
            int d1 = Math.abs(b - a);
            int d2 = Math.abs(24 * 60 - a + b);
            d2 = Math.min(d1, d2);
            min = Math.min(min, d2);
        }
        return min;
    }
}