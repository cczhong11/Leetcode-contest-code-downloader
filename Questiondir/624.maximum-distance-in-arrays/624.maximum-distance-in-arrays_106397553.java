import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {


    public int maxDistance(int[][] arrays) {
        int ans = Integer.MIN_VALUE;
        List<Integer> max = new ArrayList<>();
        for (int[] a : arrays) {
            max.add(a[a.length - 1]);
        }
        Collections.sort(max);
        for (int[] a : arrays) {
            int big = a[a.length - 1] == max.get(max.size() - 1) ? max.get(max.size() - 2) : max.get(max.size() - 1);
            ans = Math.max(ans, big - a[0]);
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxDistance(new int[][]{{1, 4}, {1}}));
    }

}