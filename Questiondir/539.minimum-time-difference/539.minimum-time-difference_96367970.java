import java.io.*;
import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {

    public int findMinDifference(List<String> timePoints) {
        timePoints = new ArrayList<>(timePoints);
        Collections.sort(timePoints);
        timePoints.add(timePoints.get(0));
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < timePoints.size(); i++) {
            int cb = Math.abs(f(timePoints.get(i)) - f(timePoints.get(i - 1)));
            ans = Math.min(ans, Math.min(cb, 24 * 60 - cb));
        }
        return ans;
    }

    private int f(String s) {
//        System.out.println(s.split(":")[0]);
//        System.out.println(s.split(":")[1]);
        return Integer.parseInt(s.split(":")[0]) * 60 + Integer.parseInt(s.split(":")[1]);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findMinDifference(Arrays.asList("05:31", "22:08", "00:35")));

    }
}