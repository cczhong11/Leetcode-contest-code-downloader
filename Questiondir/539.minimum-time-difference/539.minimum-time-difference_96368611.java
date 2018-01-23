public class Solution {
    public int findMinDifference(List<String> timePoints) {
        int ans = Integer.MAX_VALUE;
        int[] array = new int[20010];
        int length = timePoints.size();
        for (int i = 0; i < length; i++) {
            String time = timePoints.get(i);
            array[i] = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
        }
        Arrays.sort(array, 0, length);
        for (int i = 0, maxi = length - 1; i < maxi; i++) {
            int diff = array[i + 1] - array[i];
            ans = Math.min(ans, diff);
        }
        ans = Math.min(ans, 60 * 24 - (array[length - 1] - array[0]));
        return ans;
    }
}