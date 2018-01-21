import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Solution {


    public int[] smallestRange(int[][] nums) {
        if (nums.length == 1) {
            int a = nums[0][0];
            return new int[]{a, a};
        }

        int[] res = null;
        TreeSet<int[]> tree = new TreeSet<>(Comparator.<int[]>comparingInt(u -> nums[u[0]][u[1]]).thenComparingInt(u -> u[0]));
        for (int i = 0; i < nums.length; i++)
            tree.add(new int[]{i, nums[i].length - 1});
        while (tree.size() == nums.length) {
            int[] max = tree.pollLast();
            int[] min = tree.first();
            int begin = nums[min[0]][min[1]], end = nums[max[0]][max[1]];
            if (res == null)
                res = new int[]{begin, end};
            else {
                if (end - begin < res[1] - res[0] || (end - begin == res[1] - res[0] && begin < res[0])) {
                    res[0] = begin;
                    res[1] = end;
                }
            }
            if (max[1] > 0) {
                max[1]--;
                tree.add(max);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] a = sol.smallestRange(new int[][]{
                {4, 10, 15, 24, 26},
                {0, 9, 12, 20},
                {5, 18, 22, 30},
        });
        System.out.println(Arrays.toString(a));
    }
}