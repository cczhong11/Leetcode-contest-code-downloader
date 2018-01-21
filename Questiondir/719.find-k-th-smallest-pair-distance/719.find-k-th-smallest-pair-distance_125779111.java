import java.util.*;
import java.math.*;
import java.util.stream.*;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        Random rand = new Random();
        int[] a = new int[20];
        for (int i = 0; i < a.length; i++)
            a[i] = rand.nextInt(100);
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        List<Integer> hehe = new ArrayList<>();
        for (int i = 1; i <= 20 * 19 / 2; i++)
            hehe.add(sol.smallestDistancePair(a, i));

        List<Integer> expected = new ArrayList<>();
        for (int i = 0; i < a.length; i++)
            for (int j = i + 1; j < a.length; j++)
                expected.add(Math.abs(a[i] - a[j]));
        Collections.sort(expected);
        System.out.println(hehe.equals(expected));
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = 1000000;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (leCnt(nums, mid) < k) {
                left = mid + 1;
            } else {
                if (leCnt(nums, mid - 1) < k) return mid;
                else right = mid - 1;
            }
        }
        throw new RuntimeException("");
    }

    private int leCnt(int[] a, int x) {
        int cnt = 0;
        for (int l = 0, r = 0; r < a.length; r++) {
            while (l < r && a[r] - a[l] > x) l++;
            cnt += r - l;
        }
        return cnt;
    }
}
