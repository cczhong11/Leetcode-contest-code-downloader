public class Solution {
  public int findMinDifference(List<String> timePoints) {
    final int n = timePoints.size();
    int[] minutes = new int[n*2];
    int index = 0;
    for (String point : timePoints) {
      int num = toMinutes(point);
      minutes[index++] = num;
      minutes[index++] = num + 24*60;
    }

    Arrays.sort(minutes);
    int min = Integer.MAX_VALUE;
    for (int i = 1; i < n*2; i++) {
      int d = minutes[i] - minutes[i-1];
      if (d < min) {
        min = d;
      }
    }
    return min;
  }

  private static int toMinutes(String s) {
    return Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3, 5));
  }
}